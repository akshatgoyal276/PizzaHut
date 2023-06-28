package com.app.pizzahut.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.app.pizzahut.databinding.DialogFragmentPizzaOptionsBinding
import com.app.pizzahut.databinding.FragmentMainBinding

class PizzaOptionsDialogFragment : DialogFragment() {

    companion object {

        const val TAG = "PizzaOptionsDialogFragment"

        fun newInstance(): PizzaOptionsDialogFragment {
            return PizzaOptionsDialogFragment()
        }

    }

    private lateinit var binding: DialogFragmentPizzaOptionsBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DialogFragmentPizzaOptionsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
}