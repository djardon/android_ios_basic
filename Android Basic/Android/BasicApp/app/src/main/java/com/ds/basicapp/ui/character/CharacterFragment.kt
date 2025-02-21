package com.ds.basicapp.ui.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.ds.basicapp.databinding.FragmentCharacterBinding
import com.ds.basicapp.domain.models.Character
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    private val viewModel: CharacterViewModel by viewModel()

    private val args: CharacterFragmentArgs by navArgs()
    private lateinit var character: Character

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        character = args.character
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var title = ""
        if (character.name.isNotBlank()) {
            title = character.name
        }

        if (character.biography.fullName.isNotBlank()) {
            title = if (title.isEmpty()) {
                character.biography.fullName
            } else {
                "$title - ${character.biography.fullName}"
            }
        }

        (requireActivity() as AppCompatActivity).supportActionBar?.title = title
        println(character)

    }
}