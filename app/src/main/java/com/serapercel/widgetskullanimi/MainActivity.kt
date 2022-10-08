package com.serapercel.widgetskullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.serapercel.widgetskullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Image View
        binding.buttonResim1.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.resim1)
        }

        binding.buttonResim2.setOnClickListener {
            binding.imageView.setImageResource(
                resources.getIdentifier(
                    "resim2",
                    "drawable",
                    packageName
                )
            )
        }
        // v - switch'in kendisi, b - switch'in durumu (true/false)
        binding.switch1.setOnCheckedChangeListener { v, b ->
            if (b) {
                Log.e("widgets", "Switch : ON")
            } else {
                Log.e("widgets", "Switch : OFF")
            }
        }

        binding.butonGoster.setOnClickListener {
            Log.e("widgets", "Switch durum : ${binding.switch1.isChecked}")
        }
    }
}