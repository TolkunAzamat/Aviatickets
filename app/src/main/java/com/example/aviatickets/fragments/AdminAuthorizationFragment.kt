package com.example.aviatickets.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.compose.runtime.Composer.Companion.Empty
import androidx.navigation.fragment.findNavController
import com.example.aviatickets.R
import com.example.aviatickets.admin.AdminActivity
import com.example.aviatickets.database.entities.appDatabase.App
import com.example.aviatickets.database.entities.entities.Admin
import com.example.aviatickets.database.entities.entities.User
import com.example.aviatickets.databinding.FragmentAdminAuthorizationBinding
import com.example.aviatickets.databinding.FragmentAuthorizationBinding

class AdminAuthorizationFragment : Fragment() {
    private var _binding: FragmentAdminAuthorizationBinding? = null
    private val binding get() = _binding!!
    lateinit var number: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAdminAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = App.instance?.getDatabase()?.Dao()

        binding.backtoUserauth.setOnClickListener {
            findNavController().navigate(AdminAuthorizationFragmentDirections.actionAdminAuthorizationFragmentToAuthorizationFragment())
        }
db?.insertAdmin(
   Admin(
        idAdmin = null,
        phoneNumberAdmin = "+996502025015",
        passwordAdmin = "20222"
    ))

        binding.saveAdmin.setOnClickListener {
            if (binding.adminPhone.text.isNullOrBlank() && binding.adminPassword.text.isNullOrBlank()){
                binding.adminPhone.error = "Укажите номер"
                binding.adminPassword.error = "Заполните пароль"
            } else{
                val adminPhone = App.instance?.getDatabase()?.Dao()?.getAdminNumber(binding.adminPhone.text.toString())
                val adminPassword=App.instance?.getDatabase()?.Dao()?.getAdminPassword(binding.adminPassword.text.toString())
                if (adminPhone?.phoneNumberAdmin== binding.adminPhone.text.toString()&& adminPassword==binding.adminPassword.text.toString()) {

              startActivity(Intent(requireActivity(), AdminActivity::class.java))
                }
                else{
                    Toast.makeText(context, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show()
                }
                }

        }
    }
}