package com.example.aviatickets.User

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.aviatickets.R

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {

            setContentView(R.layout.activity_user)
        } catch (e: Exception) {
            Log.e("UserActivity", e.toString())
        }


    }
}