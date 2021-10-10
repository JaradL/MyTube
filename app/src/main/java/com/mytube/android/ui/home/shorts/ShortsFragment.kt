package com.mytube.android.ui.home.shorts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mytube.android.databinding.FragmentShortsBinding

class ShortsFragment : Fragment() {

    private lateinit var shortsViewModel: ShortsViewModel
    private var _binding: FragmentShortsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shortsViewModel =
            ViewModelProvider(this).get(ShortsViewModel::class.java)

        _binding = FragmentShortsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textStories
        shortsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}