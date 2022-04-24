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
import com.example.aviatickets.databinding.FragmentAdminHomeBinding


class AdminHomeFragment : Fragment() {
    private var _binding: FragmentAdminHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { FlightAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAdminHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        binding.backA.setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity::class.java))
        }
        binding.addTimeTable.setOnClickListener {
            findNavController().navigate(R.id.addAdminFragment)
        }
        adapter.onItemClickListener {
            val bundle = Bundle().apply {
                putBoolean("isUpdate", true)
                putParcelable("data", it)
            }
            findNavController().navigate(R.id.addAdminFragment, bundle)
        }
    }


    private fun setAdapter() {
        val db = App.instance?.getDatabase()?.Dao()
        db?.getAllFlights()?.let { adapter.setList(it) }
        binding.recycleTimeTable.adapter = adapter
        binding.recycleTimeTable.invalidate()
    }
}