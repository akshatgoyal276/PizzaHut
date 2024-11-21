package com.app.pizzahut.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.app.pizzahut.adapter.PizzaListAdapter
import com.app.pizzahut.data.modals.dataModals.Pizza
import com.app.pizzahut.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.notify
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by activityViewModels()

    @Inject
    lateinit var adapter: PizzaListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        binding.rvPizzaList.adapter = adapter
        adapter.onClick = {
            openPizzaOptions(it)
        }
        binding.vm = viewModel
        return binding.root
    }

    private fun openPizzaOptions(item: Pizza) {
        PizzaOptionsDialogFragment(item).show(parentFragmentManager, "Options Dialog Fragment")
    }

    override fun onResume() {
//        viewModel.getPizzaList()
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.setAdapterList(it)
        }
        viewModel.selectedPizzaList.observe(viewLifecycleOwner){
            binding.invalidateAll()
        }
        super.onResume()
    }

}