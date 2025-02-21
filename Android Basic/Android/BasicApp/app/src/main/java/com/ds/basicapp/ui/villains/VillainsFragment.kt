package com.ds.basicapp.ui.villains

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ds.basicapp.R
import com.ds.basicapp.databinding.FragmentVillainsBinding
import com.ds.basicapp.domain.models.Character
import com.ds.basicapp.ui.adapters.CharacterViewAdapter
import com.ds.basicapp.ui.heroes.HeroFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class VillainsFragment: Fragment(), CharacterViewAdapter.OnItemClickListener {

    private lateinit var binding: FragmentVillainsBinding
    private val viewModel: VillainsViewModel by viewModel()

    private val columnCount = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVillainsBinding.inflate(inflater, container, false)

        with(binding.villainList) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.villainsLiveData.observe(viewLifecycleOwner) {
            binding.villainList.adapter = CharacterViewAdapter(it, this)
        }

        viewModel.loadData()
    }

    override fun onItemClick(item: Character?) {
        item?.let {
            val navController = findNavController()
            val action = VillainsFragmentDirections.actionVillainsFragmentToCharacterFragment(item)
            navController.navigate(action)
        }
    }
}