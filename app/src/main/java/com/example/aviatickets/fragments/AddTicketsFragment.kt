package com.example.aviatickets.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.aviatickets.R
import com.example.aviatickets.database.entities.appDatabase.App
import com.example.aviatickets.databinding.FragmentAddTicketsBinding
import java.text.SimpleDateFormat

class AddTicketsFragment : Fragment(){
    private var _binding: FragmentAddTicketsBinding? = null
    private val binding get() = _binding!!

    var flights:Int?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAddTicketsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = App.instance?.getDatabase()?.Dao()
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm")
        binding.saveT.setOnClickListener {
            if (binding.fnamepassenger.text.isNullOrBlank() && binding.lnamepassenger.text.isNullOrBlank() && binding.userPassport.text.isNullOrBlank()) {
                binding.fnamepassenger.error = "Заполните поле"
                binding.lnamepassenger.error = "Заполните поле"
                binding.userPassport.error = "Заполните поле"
            } else {

            }

        }
    }
}