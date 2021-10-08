package com.mytube.android.ui.home.subscriptions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mytube.android.databinding.FragmentSubscriptionsBinding

class SubscriptionsFragment : Fragment() {

    private lateinit var subscriptionsViewModel: SubscriptionsViewModel
    private var _binding: FragmentSubscriptionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subscriptionsViewModel =
            ViewModelProvider(this).get(SubscriptionsViewModel::class.java)

        _binding = FragmentSubscriptionsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSubscriptions
        subscriptionsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}