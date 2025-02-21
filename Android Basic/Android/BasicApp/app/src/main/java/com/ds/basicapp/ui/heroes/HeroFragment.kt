package com.ds.basicapp.ui.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ds.basicapp.databinding.FragmentHeroesBinding
import com.ds.basicapp.domain.models.Character
import com.ds.basicapp.ui.adapters.CharacterViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroFragment: Fragment(), CharacterViewAdapter.OnItemClickListener {

    private lateinit var binding: FragmentHeroesBinding
    private val viewModel: HeroViewModel by viewModel()

    private val columnCount = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroesBinding.inflate(inflater, container, false)

        with(binding.heroList) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.charactersLiveData.observe(viewLifecycleOwner) {
            binding.heroList.adapter = CharacterViewAdapter(it, this)
        }

        viewModel.loadData()
    }

    override fun onItemClick(item: Character?) {
        item?.let {
            val navController = findNavController()
            val action = HeroFragmentDirections.actionHeroesFragmentToCharacterFragment(item)
            navController.navigate(action)
        }
    }
}