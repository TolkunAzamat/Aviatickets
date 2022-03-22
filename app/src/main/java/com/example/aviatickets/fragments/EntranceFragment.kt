package com.example.aviatickets.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.aviatickets.R
import com.example.aviatickets.databinding.FragmentEntranceBinding

class EntranceFragment : Fragment() {
    private var _binding: FragmentEntranceBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentEntranceBinding.inflate(inflater, container, false)
        return binding.root }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.register.setOnClickListener {
            findNavController().navigate(EntranceFragmentDirections.actionEntranceFragmentToRegistrationFragment())
        }
        binding.authoriz.setOnClickListener {
            findNavController().navigate(EntranceFragmentDirections.actionEntranceFragmentToAuthorizationFragment())
        }
    }
}