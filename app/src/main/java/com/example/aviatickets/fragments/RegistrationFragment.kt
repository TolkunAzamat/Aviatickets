package com.example.aviatickets.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.aviatickets.MainActivity
import com.example.aviatickets.R
import com.example.aviatickets.User.UserActivity
import com.example.aviatickets.admin.AdminActivity
import com.example.aviatickets.database.entities.appDatabase.App
import com.example.aviatickets.database.entities.entities.User
import com.example.aviatickets.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    val idUser: Int? = null
    val adminUsername = "admin"
    val adminPassword = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = App.instance?.getDatabase()?.Dao()
        binding.saveUser.setOnClickListener {
            if (binding.userPhone.text.isNullOrBlank() && binding.userPassword.text.isNullOrBlank()) {
                binding.userPhone.error = "Укажите номер"
                binding.userPassword.error = "Заполните пароль"
            } else {
                val phones = App.instance?.getDatabase()?.Dao()?.getUserNumbers(binding.userPhone.text.toString())
                if(phones?.phoneNumber == binding.userPhone.text.toString())
                {
                    Toast.makeText(context, "Такой пользователь уже существует!!!", Toast.LENGTH_SHORT).show()
                }
  else {
                    db?.insertUser(
                        User(
                            idUser = null,
                            phoneNumber = binding.userPhone.text.toString(),
                            password = binding.userPassword.text.toString()
                        ))
                    findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToEntranceFragment())
                }
            }
        }
        binding.backtoEntrance.setOnClickListener {
            findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToEntranceFragment())
        }
    }

}