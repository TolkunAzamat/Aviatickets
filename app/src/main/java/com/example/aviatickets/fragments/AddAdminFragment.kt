package com.example.aviatickets.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.aviatickets.R
import com.example.aviatickets.database.entities.appDatabase.App
import com.example.aviatickets.database.entities.entities.Flights
import com.example.aviatickets.databinding.FragmentAddAdminBinding
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class AddAdminFragment : Fragment(R.layout.fragment_add_admin) {
    private lateinit var binding: FragmentAddAdminBinding
    private val calendar:Calendar= Calendar.getInstance()
    val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.US)

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
        setFocusSettings(binding.addWhatDate, binding.addWhatTime)
        setFocusSettings(binding.addDateArriving, binding.addTimeArriving)
    }

    private fun updateFlight() {
        val db = App.instance?.getDatabase()?.Dao()
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm")
        val id = arguments?.getParcelable<Flights>("data")
        binding.nameflight.setText(id?.flightName)
        binding.addWhence.setText(id?.departing)
        binding.addWhere.setText(id?.arriving)
        binding.addPlaneName.setText(id?.planeName)
        binding.price.setText(id?.price.toString())
        binding.addWhatTime.setText(id?.dateDeparting.toString())
        binding.addTimeArriving.setText(id?.dateArriving.toString())

        binding.saveFlights.setOnClickListener {
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
                    sdf.parse("${binding.addWhatDate.text} ${binding.addWhatTime.text}"),
                    sdf.parse("${binding.addDateArriving.text} ${binding.addTimeArriving.text}"),
                    binding.addPlaneName.text.toString(),
                    binding.price.text.toString().toInt()
                )
                db?.insertFlight(data)

                findNavController().navigate(AddAdminFragmentDirections.actionAddAdminFragmentToAdminHomeFragment())
            }
        }
        binding.backtoHome.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }
    }

    private fun setFocusSettings(editText: EditText, time: EditText) {
        editText.setOnFocusChangeListener { _, b ->
            if (b) {
                datePicker(editText, time)
                editText.setOnClickListener {
                    datePicker(editText, time)
                }
            }

        }
    }

    private fun datePicker(editText: EditText, time: EditText){
        val year=calendar.get(Calendar.YEAR)
        val month=calendar.get(Calendar.MONTH)
        val day=calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val dpd=DatePickerDialog(requireContext() ,{_,y,m,d->
            val tpd = TimePickerDialog(requireContext(), { timePicker, i, i2 ->
                time.setText("$i:$i2")
            }, hour, minute, true)
            tpd.show()
            val input=sdf.parse("${d}.${m+1}.${y}")
            val output=sdf.format(input)
            editText.setText(output)

        }, year,month,day)
        dpd.show()
    }
}