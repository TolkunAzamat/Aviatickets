package com.example.aviatickets.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.aviatickets.R
import com.example.aviatickets.database.entities.appDatabase.App
import com.example.aviatickets.database.entities.entities.Flights
import com.example.aviatickets.databinding.FragmentAddAdminBinding
import java.text.SimpleDateFormat
import java.util.*

class AddAdminFragment : Fragment(R.layout.fragment_add_admin) {
    private lateinit var binding: FragmentAddAdminBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAddAdminBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments?.getBoolean("isUpdate") == true) {
            updateFlight()
        } else {
            addFlight()
        }
    }

    private fun calculateTicketPrice(price: Int, percent: Int): Int {
        return (price * percent) / 100
    }

    private fun updateFlight() {
        val db = App.instance?.getDatabase()?.Dao()
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm")
        val id = arguments?.getParcelable<Flights>("data")
        binding.addWhence.setText(id?.departing)
        binding.addWhere.setText(id?.arriving)
        binding.saveFlights.setOnClickListener {
            val data = Flights(
                id?.idFlights,
                binding.nameflight.text.toString(),
                binding.addWhence.text.toString(),
                binding.addWhere.text.toString(),
                sdf.parse(binding.addWhatTime.text.toString()),
                sdf.parse(binding.addWhatTime.text.toString()),
                binding.addPlaneName.text.toString(),
                binding.price.text.toString().toInt()
            )


                // binding.твойЧоксбокс.isChecked

            db?.updateTicket(data)
            findNavController().navigate(AddAdminFragmentDirections.actionAddAdminFragmentToAdminHomeFragment())
        }
    }

    private fun addFlight() {
        val db = App.instance?.getDatabase()?.Dao()
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm")
        binding.saveFlights.setOnClickListener {
            if (binding.addWhence.text.isNullOrBlank() && binding.addWhere.text.isNullOrBlank()&& binding.addWhatTime.text.isNullOrBlank()
                && binding.addTimeArriving.text.isNullOrBlank()&&binding.price.text.isNullOrBlank()) {
                binding.nameflight.error="Заполните поле"
                binding.addWhence.error = "Заполните поле"
                binding.addWhere.error = "Заполните поле"
                binding.addWhatTime.error = "Заполните поле"
                binding.addTimeArriving.error = "Заполните поле"
                binding.price.error = "Заполните поле"
            }
            else {
                val data = Flights(
                    null,
                    binding.nameflight.text.toString(),
                    binding.addWhence.text.toString(),
                    binding.addWhere.text.toString(),
                    sdf.parse(binding.addWhatTime.text.toString()),
                    sdf.parse(binding.addWhatTime.text.toString()),
                    binding.addPlaneName.text.toString(),
                    binding.price.text.toString().toInt()
                )
                db?.insertFlight(data)

                findNavController().navigate(AddAdminFragmentDirections.actionAddAdminFragmentToAdminHomeFragment())
            }
        }
    }
}