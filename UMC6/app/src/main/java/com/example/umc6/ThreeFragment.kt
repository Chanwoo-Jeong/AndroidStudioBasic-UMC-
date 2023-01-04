package com.example.umc6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.umc6.databinding.FragmentHomeBinding
import com.example.umc6.databinding.FragmentOneBinding

import com.example.umc6.databinding.FragmentThreeBinding
import com.example.umc6.databinding.FragmentTwoBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ThreeFragment : Fragment() {

    private var _binding: FragmentThreeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThreeBinding.inflate(inflater, container, false)
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