package com.example.aviatickets.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.aviatickets.R
import com.example.aviatickets.User.UserActivity
import com.example.aviatickets.database.entities.appDatabase.App
import com.example.aviatickets.databinding.FragmentAuthorizationBinding
import com.example.aviatickets.databinding.FragmentSearchFlightsBinding


class SearchFlightsFragment : Fragment() {
    private var _binding: FragmentSearchFlightsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSearchFlightsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val from = App.instance?.getDatabase()?.Dao()?.getAllDeparting()
        val to = App.instance?.getDatabase()?.Dao()?.getAllArriving()
        Toast.makeText(context,
            "Просьба писать название городов с большой буквы",
            Toast.LENGTH_LONG).show()
        binding.searchP.setOnClickListener {
            if (binding.searchWhence.text.isNullOrBlank() && binding.searchWhere.text.isNullOrBlank()) {
                binding.searchWhence.error = "Укажите город"
                binding.searchWhere.error = "Укажите город"
            } else {

                val arriving = App.instance?.getDatabase()?.Dao()?.getArriving(binding.searchWhere.text.toString())
                val depart = App?.instance?.getDatabase()?.Dao()?.getDeparting(binding.searchWhence.text.toString())
                val fl = App.instance?.getDatabase()?.Dao()?.getAllFlight(
                    dep = binding.searchWhence.text.toString(),
                    arr = binding.searchWhere.text.toString()
                )
                if (depart == binding.searchWhence.text.toString() && arriving == binding.searchWhere.text.toString()) {

                    val flightInfo = "Название рейса: ${fl?.flightName}\nДата отправки: ${fl?.dateDeparting}\n" +
                            "Дата прибытия: ${fl?.dateArriving}\nНазвание самолета: ${fl?.planeName}\n" +
                            "Дата отправки: ${fl?.price}\n"
                    binding.flights.text = flightInfo
                    binding.registration.setOnClickListener {
                        findNavController().navigate(SearchFlightsFragmentDirections.actionSearchFlightsFragmentToAddTicketsFragment())
                    }
                } else {
                    Toast.makeText(context, "Рейс не найден!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        if (to != null) {
            adapter(to, binding.searchWhere)
            setFocusChanges(binding.searchWhere)
        }

        if (from != null) {
            adapter(from, binding.searchWhence)
            setFocusChanges(binding.searchWhence)
        }
    }

    private fun adapter(list: List<String>, autoCompleteTextView: AutoCompleteTextView) {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, list)
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.threshold = 1
    }

    private fun setFocusChanges(autoCompleteTextView: AutoCompleteTextView) {
        autoCompleteTextView.setOnFocusChangeListener { view, b ->
            if (b) {
                autoCompleteTextView.showDropDown()
            }
        }
    }


}