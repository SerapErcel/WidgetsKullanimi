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

        // Switch
        // v - switch'in kendisi, b - switch'in durumu (true/false)
        binding.switch1.setOnCheckedChangeListener { v, b ->
            if (b) {
                Log.e("widgets", "Switch : ON")
            } else {
                Log.e("widgets", "Switch : OFF")
            }
        }

        // Check Box
        // v - checkBoxKotlin'in kendisi, b - checkBoxKotlin'in durumu (true/false)
        binding.checkBoxKotlin.setOnCheckedChangeListener { v, b ->
            if (b) {
                Log.e("widgets", "Kotlin Seçildi")
            }
        }

        // v - checkBoxJava'in kendisi, b - checkBoxJava'in durumu (true/false)
        binding.checkBoxJava.setOnCheckedChangeListener { v, b ->
            if (b) {
                Log.e("widgets", "Java Seçildi")
            }
        }

        // Radio Button
        // v - radioButtonBarcelona'in kendisi, b - radioButtonBarcelona'in durumu (true/false)
        binding.radioButtonBarcelona.setOnCheckedChangeListener { v, b ->
            if (b) {
                Log.e("widgets", "Barcelona Seçildi")
            }
        }

        // v - radioButtonRealMadrid'in kendisi, b - radioButtonRealMadrid'in durumu (true/false)
        binding.radioButtonRealMadrid.setOnCheckedChangeListener { v, b ->
            if (b) {
                Log.e("widgets", "RealMadrid Seçildi")
            }
        }

        binding.butonGoster.setOnClickListener {
            Log.e("widgets", "Switch durum : ${binding.switch1.isChecked}")
            Log.e("widgets", "Switch durum : ${binding.checkBoxKotlin.isChecked}")
            Log.e("widgets", "Switch durum : ${binding.checkBoxJava.isChecked}")
            Log.e("widgets", "Switch durum : ${binding.radioButtonBarcelona.isChecked}")
            Log.e("widgets", "Switch durum : ${binding.radioButtonRealMadrid.isChecked}")
        }
    }
}