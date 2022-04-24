package com.example.aviatickets.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.aviatickets.MainActivity
import com.example.aviatickets.R
import com.example.aviatickets.User.UserActivity
import com.example.aviatickets.admin.adapter.FlightAdapter
import com.example.aviatickets.database.entities.appDatabase.App
import com.example.aviatickets.databinding.FragmentAddTicketsBinding
import com.example.aviatickets.databinding.FragmentUserHomeBinding


class UserHomeFragment : Fragment() {
    private var _binding: FragmentUserHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentUserHomeBinding.inflate(layoutInflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    binding.addTickets.setOnClickListener {
        findNavController().navigate(R.id.searchFlightsFragment)
    }
        binding.backA.setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity::class.java))
        }
    }
}