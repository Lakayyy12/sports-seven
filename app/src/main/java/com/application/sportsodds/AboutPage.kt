package com.application.sportsodds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutPage : AppCompatActivity() {

    private var btnA : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        btnA = findViewById(R.id.btnA)
        btnA?.setOnClickListener{
            onBackPressed()
        }
    }
}