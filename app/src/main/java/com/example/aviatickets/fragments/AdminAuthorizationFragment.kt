package com.example.aviatickets.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.compose.runtime.Composer.Companion.Empty
import androidx.navigation.fragment.findNavController
import com.example.aviatickets.R
import com.example.aviatickets.admin.AdminActivity
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
        number = view.findViewById(R.id.adminPhone)

        binding.backtoUserauth.setOnClickListener {
            findNavController().navigate(AdminAuthorizationFragmentDirections.actionAdminAuthorizationFragmentToAuthorizationFragment())
        }


        binding.saveAdmin.setOnClickListener {
            if (binding.adminPhone.text.isNullOrBlank() && binding.adminPassword.text.isNullOrBlank()){
                binding.adminPhone.error = "Укажите номер"
                binding.adminPassword.error = "Заполните пароль"
            } else{
            startActivity(Intent(requireActivity(), AdminActivity::class.java))}
        }
    }
}