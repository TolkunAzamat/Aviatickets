package com.example.aviatickets.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.aviatickets.database.entities.appDatabase.App
import com.example.aviatickets.databinding.FragmentAuthorizationBinding


class AuthorizationFragment : Fragment() {
    private var _binding: FragmentAuthorizationBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbUser = App.instance?.getDatabase()?.Dao()
        val UserPhone = dbUser?.getPhoneNumbers()
        binding.btnback.setOnClickListener {
            findNavController().navigate(AuthorizationFragmentDirections.actionAuthorizationFragmentToEntranceFragment())
        }
        binding.admin.setOnClickListener {
            Toast.makeText(context, "Вход для админа", Toast.LENGTH_SHORT).show()
            findNavController().navigate(AuthorizationFragmentDirections.actionAuthorizationFragmentToAdminAuthorizationFragment())
        }
        binding.saveUser.setOnClickListener {
                if (binding.userPhone.text.isNullOrBlank() && binding.userPassword.text.isNullOrBlank()){
                    binding.userPhone.error = "Укажите номер"
                    binding.userPassword.error = "Заполните пароль"
                } else
                {
                    val phones = App.instance?.getDatabase()?.Dao()?.getUserNumbers("+996502025015")

                    Log.e("Phone", phones.toString())
                    if (phones?.phoneNumber==binding.userPhone.text.toString()) {
                        Toast.makeText(context, "jdfdjshfd", Toast.LENGTH_SHORT).show()
                        Log.e("Phone", phones.toString())
                    }
                    }
                                //startActivity(Intent(requireActivity(), UserActivity::class.java))
                                }
                            }
                        }
