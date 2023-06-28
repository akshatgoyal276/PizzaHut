package com.app.pizzahut.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.pizzahut.adapter.ListAdapter
import com.app.pizzahut.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        binding.appListRecyclerView.adapter = adapter
        adapter.setAdapterList(listOf("", "", "", "", "", "", "", "", ""))
        return binding.root
    }

}