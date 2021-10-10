package com.mytube.android.ui.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mytube.android.data.local.MainRepository
import com.mytube.android.data.remote.ApiInterface
import com.mytube.android.databinding.FragmentHomeBinding
import java.lang.StringBuilder

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val apiInterface = ApiInterface.create()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        val homeViewModel = ViewModelProvider(this, HomeViewModelFactory(MainRepository(apiInterface))).get(HomeViewModel::class.java)
        binding.viewModel = homeViewModel
        val root: View = binding.root

//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        binding.viewModel = homeViewModel

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}