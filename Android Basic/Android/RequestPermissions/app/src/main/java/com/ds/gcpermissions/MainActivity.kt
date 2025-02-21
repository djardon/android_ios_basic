package com.ds.gcpermissions

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ds.gcpermissions.databinding.ActivityMainBinding
import java.io.File
import java.io.IOException

/*
Los permisos críticos más comunes incluyen:

- Cámara (Manifest.permission.CAMERA)
- Ubicación (Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
- Almacenamiento (Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE — deprecados Android 10)
- Micrófono (Manifest.permission.RECORD_AUDIO)
- Contactos (Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS)
- Teléfono (Manifest.permission.CALL_PHONE, Manifest.permission.READ_PHONE_STATE)

Complejidades y Limitaciones
- One-time Permissions: A partir de Android 11 (API 30), algunos permisos (como la ubicación) pueden
    solicitarse "solo esta vez" (One-Time Permissions). Esto requiere tener en cuenta que el usuario puede
    permitir el acceso solo temporalmente.

- Acceso a almacenamiento: Desde Android 10 (API 29), se introdujo Scoped Storage, lo que limita el
    acceso a archivos compartidos. Ya no es necesario WRITE_EXTERNAL_STORAGE.

- Uso en segundo plano de la ubicación: A partir de Android 10 (API 29), se requiere una autorización
    adicional para acceder a la ubicación en segundo plano.

- Rechazo permanente de permisos: Si el usuario selecciona "No volver a preguntar", se debe dirigir
    al usuario a la configuración de la aplicación.

- Permisos granulares: Los permisos de ubicación se dividieron en ACCESS_COARSE_LOCATION y
    ACCESS_FINE_LOCATION, lo que afecta la precisión del GPS.

- Pedir permisos de forma correcta: Si un usuario ha denegado permanentemente un permiso, no se debe
    seguir pidiéndolo. Se debe mostrar un diálogo explicativo antes de dirigirlo a la configuración
    de la aplicación.
 */


class MainActivity : AppCompatActivity() {
    // Camera Permission Request Launcher
    // Declare a launcher for the camera permission request, handling the permission result
    private val cameraPermissionRequestLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                // Permission granted: proceed with opening the camera
                startDefaultCamera()
            } else {
                // Permission denied: inform the user to enable it through settings
                Toast.makeText(
                    this,
                    "Go to settings and enable camera permission to use this feature",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    private val audioPermissionRequestLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                // Permission granted: proceed with opening the audio logic
                startAudio()
            } else {
                // Permission denied: inform the user to enable it through settings
                Toast.makeText(
                    this,
                    "Go to settings and enable audio permission to use this feature",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    // Camera Intent Launcher
    // Declare a launcher for taking a picture, handling the result of the camera app
    private val takePictureLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            // This can be expanded to handle the result data
            Toast.makeText(this, "Photo taken", Toast.LENGTH_SHORT).show()
        }

    private var mediaRecorder: MediaRecorder? = null
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        binding.btnCameraAction.setOnClickListener {
            handleCameraPermission()
        }

        binding.btnAudioAction.setOnClickListener {
            handleAudioPermissions()
        }
    }

    // CAMERA
    private fun handleCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                // Permission is already granted: start the camera
                startDefaultCamera()
            }

            else -> {
                // Permission is not granted: request it
                cameraPermissionRequestLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    // Starts the default camera app for taking a picture
    private fun startDefaultCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Camera app is available: launch it
                takePictureLauncher.launch(takePictureIntent)
            } ?: run {
                // No camera app available: inform the user
                Toast.makeText(this, "No camera app available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // AUDIO
    private fun handleAudioPermissions() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED -> {
                // Permission is already granted: start the camera
                startAudio()
            }

            else -> {
                // Permission is not granted: request it
                audioPermissionRequestLauncher.launch(Manifest.permission.RECORD_AUDIO)
            }
        }
    }

    private fun startAudio() {
        if (mediaRecorder != null) {
            try {
                mediaRecorder?.stop()
                mediaRecorder = null
            } catch (error: Exception) {
                Log.e("MainActivity", "stopAudio ${error.message}")
            }
        } else {
            mediaRecorder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                MediaRecorder(applicationContext)
            } else {
                MediaRecorder()
            }.apply {
                val theAudioFile = File(filesDir, "Audio_Record_File")
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setOutputFile(theAudioFile.path)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

                try {
                    prepare()
                    start()
                } catch (error: IOException) {
                    Log.e("MainActivity", "startAudio ${error.message}")
                }
            }
        }
    }
}