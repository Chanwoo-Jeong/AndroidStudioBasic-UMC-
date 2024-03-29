package com.example.umc3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.umc3.databinding.FragmentFirstBinding
import com.example.umc3.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

        private lateinit var viewBinding: FragmentSecondBinding

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            viewBinding = FragmentSecondBinding.inflate(layoutInflater)
            return  viewBinding.root
        }

}