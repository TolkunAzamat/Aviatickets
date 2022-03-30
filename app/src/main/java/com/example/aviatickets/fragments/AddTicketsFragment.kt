package com.example.aviatickets.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.aviatickets.R
import com.example.aviatickets.database.entities.appDatabase.App
import com.example.aviatickets.database.entities.entities.Tickets
import com.example.aviatickets.databinding.FragmentAddTicketsBinding
import java.text.SimpleDateFormat

class AddTicketsFragment : Fragment()
    //(R.layout.fragment_add_tickets),
   /* AdapterView.OnItemSelectedListener {
    private lateinit var binding: FragmentAddTicketsBinding
    var departingfk: Int? = null
    var departName:String?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAddTicketsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = App.instance?.getDatabase()?.Dao()
        val departing = App.instance?.getDatabase()?.Dao()?.getArriving()
        val arriving = App.instance?.getDatabase()?.Dao()?.getDeparting()
        spinnerDeparting(binding.spinnerWhence, departing!!)
        spinnerArriving(binding.spinnerWhere, arriving!!)
        binding.spinnerWhere.onItemSelectedListener = this
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm")
        binding.saveT.setOnClickListener {
            if (binding.fnamepassenger.text.isNullOrBlank() && binding.lnamepassenger.text.isNullOrBlank() && binding.userPassport.text.isNullOrBlank()) {
                binding.fnamepassenger.error = "Заполните поле"
                binding.lnamepassenger.error = "Заполните поле"
                binding.userPassport.error = "Заполните поле"
            } else {
                val data = Tickets(
                    null,
                    binding.fnamepassenger.text.toString(),
                    binding.lnamepassenger.text.toString(),
                    binding.userPassport.text.toString(),
                    flights = arriving,
classes = null

                    )
                db?.insertTickets(data)
            }

        }
    }
    fun spinnerArriving(spinner: Spinner, list: List<String>) {
        val adapter< =ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)
        spinner.setAdapter(adapter)
    }
    fun spinnerDeparting(spinner: Spinner, list: List<String>) {
        val adapter =ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)
        spinner.setAdapter(adapter)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val arriving = App.instance?.getDatabase()?.Dao()?.getArriving()
        for (i in arriving!!) {
            if (p0?.selectedItem == i) {
                departName = i
            }
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }*/
