package com.example.productionmindsetxmlretrofit

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlin.jvm.java


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnGetJoke)

        val tv = findViewById<TextView>(R.id.tvJoke)

        viewModel = ViewModelProvider(this)[JokeViewModel::class.java]

        btn.setOnClickListener {
            viewModel.getJoke()
        }

        viewModel.jokeLiveData.observe(this) {
            tv.text = it
        }
    }
}