package com.app.pizzahut.ui.main

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.app.pizzahut.MainActivity
import com.app.pizzahut.adapter.PizzaListAdapter
import com.app.pizzahut.data.modals.dataModals.Pizza
import com.app.pizzahut.databinding.FragmentMainBinding
import com.app.pizzahut.databinding.PizzaListItemBinding
import dagger.hilt.android.AndroidEntryPoint
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
        viewModel.getPizzaList()
        viewModel.list.observe(viewLifecycleOwner){
            adapter.setAdapterList(it)
        }
        return binding.root
    }

    private fun openPizzaOptions(item:Pizza){
        PizzaOptionsDialogFragment.newInstance().show(MainActivity.activity.supportFragmentManager,"Options Dialog Fragment")
    }

}