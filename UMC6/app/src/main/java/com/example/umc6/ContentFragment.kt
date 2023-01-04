package com.example.umc6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umc6.databinding.FragmentContentBinding
import com.google.android.material.tabs.TabLayoutMediator

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ContentFragment : Fragment() {

    private var _binding: FragmentContentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentContentBinding.inflate(inflater, container, false)

        val mainVPAdapter = MainVPAdapter(this)
        binding.vpMain.adapter = mainVPAdapter

        val tabTitle = arrayOf(
            "One",
            "Two",
            "Three"
        )

        TabLayoutMediator(binding.tabMain,binding.vpMain){tab, position ->
            tab.text = tabTitle[position]
        }.attach()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}