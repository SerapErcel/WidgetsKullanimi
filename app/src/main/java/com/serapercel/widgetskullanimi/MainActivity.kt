package com.serapercel.widgetskullanimi

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.ColorRes
import com.google.android.material.snackbar.Snackbar
import com.serapercel.widgetskullanimi.databinding.ActivityMainBinding
import java.util.Calendar

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

        // ProgressBar
        binding.buttonBasla.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
        }
        binding.buttonBitir.setOnClickListener {
            binding.progressBar.visibility = View.INVISIBLE
        }

        // Slider
        binding.slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.textViewSonuc.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        // TimePicker
        binding.buttonSaat.setOnClickListener {
            val calendar = Calendar.getInstance()
            val saat = calendar.get(Calendar.HOUR_OF_DAY)
            val dakika = calendar.get(Calendar.MINUTE)

            val tp = TimePickerDialog(this, { t, s, dk ->
                binding.textViewZaman.text = "$s : $dk"
            }, saat, dakika, true)
            tp.show()

        }

        // DatePicker
        binding.buttonTarih.setOnClickListener {
            val calendar = Calendar.getInstance()
            val yil = calendar.get(Calendar.YEAR)
            val ay = calendar.get(Calendar.MONTH)
            val gun = calendar.get(Calendar.DAY_OF_MONTH)

            val dp = DatePickerDialog(this, { d, y, a, g ->
                binding.textViewZaman.text = "$g/${a + 1}/$y"
            }, yil, ay, gun)
            dp.show()
        }

        val ulkeler = ArrayList<String>()
        ulkeler.add("Türkiye")
        ulkeler.add("İtalya")
        ulkeler.add("Japonya")

        // Spinner
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler)
        binding.spinner.adapter = adapter

        binding.butonGoster.setOnClickListener {
            Log.e("widgets", "Switch durum : ${binding.switch1.isChecked}")
            Log.e("widgets", "Kotlin durum : ${binding.checkBoxKotlin.isChecked}")
            Log.e("widgets", "Java durum : ${binding.checkBoxJava.isChecked}")
            Log.e("widgets", "Barcelona durum : ${binding.radioButtonBarcelona.isChecked}")
            Log.e("widgets", "Real Madrid durum : ${binding.radioButtonRealMadrid.isChecked}")
            Log.e("widgets", "Slider durum : ${binding.slider.progress}")
            Log.e("widgets", "Spinner durum : ${ulkeler.get(binding.spinner.selectedItemPosition)}")

        }

        // Toast Message (eski yapi)
        binding.buttonToast.setOnClickListener {
            Toast.makeText(this, "Merhaba", Toast.LENGTH_LONG).show()
        }

        // SnackBar Message (guncel kullanilan yapi)
        binding.buttonSnackBar.setOnClickListener {
            Snackbar.make(it, "Silmek istiyor musunuz?", Snackbar.LENGTH_SHORT)
                .setAction("Evet") {
                    Snackbar.make(it, "Silindi", Snackbar.LENGTH_SHORT)
                        .setTextColor(Color.BLUE)
                        .setBackgroundTint(Color.WHITE)
                        .show()
                }
                .setActionTextColor(Color.RED)
                .setTextColor(Color.BLUE)
                .setBackgroundTint(Color.WHITE)
                .show()
        }

        // Alert Dialog
        binding.buttonAlert.setOnClickListener {
            val ad = AlertDialog.Builder(this)
            ad.setTitle("Başlık")
            ad.setMessage("İçerik")
            ad.setIcon(R.drawable.resim1)

            ad.setPositiveButton("Tamam"){s,d ->
                Toast.makeText(this, "Tamam Seçildi", Toast.LENGTH_LONG).show()
            }
            ad.setNegativeButton("İptal"){s,d ->
                Toast.makeText(this, "İptal Seçildi", Toast.LENGTH_LONG).show()
            }

            ad.create().show()
        }
    }
}