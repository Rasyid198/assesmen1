package org.d3if4075.zodiakapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import org.d3if4075.zodiakapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { zodiakApp() }
    }
    private fun zodiakApp() {
        val tanggalLahir = binding.tanggalLahirInp.text.toString()
        if (TextUtils.isEmpty(tanggalLahir)) {
            Toast.makeText(this, R.string.tanggalLahir, Toast.LENGTH_LONG).show()
            return
        }
        val bulanLahir = binding.tanggalLahirInp.text.toString()
        if (TextUtils.isEmpty(tanggalLahir)) {
            Toast.makeText(this, R.string.bulanLahir, Toast.LENGTH_LONG).show()
            return
        }
        val zodiak = bulanLahir.toFloat() * 100
        val selectedId = binding.radioGroup.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this, R.string.pilih_sebagai, Toast.LENGTH_LONG).show()
            return
        }
        val bulan = selectedId == R.id.januariButton
        val tanggal = tanggalLahir.toFloat() * (zodiak / 100)
        val deskripsi = getDeskripsi(tanggal, bulan)
        binding.zodiakText.text = getString(R.string.zodiak_x, tanggal)
        binding.deskripsiText.text = getString(R.string.deskripsi_x, deskripsi)
    }

    fun getDeskripsi(tanggal: Float, bulan: Boolean): String {
        val stringRes = if (bulan) {
            when {
                tanggal < 20 -> R.string.aquarius
                tanggal < 40 -> R.string.pisces
                tanggal < 65 -> R.string.aries
                tanggal < 85 -> R.string.taurus
                tanggal < 105 -> R.string.gemini
                tanggal < 126 -> R.string.cancer
                tanggal < 150-> R.string.leo
                tanggal < 170 -> R.string.virgo
                tanggal < 190-> R.string.libra
                tanggal < 210 -> R.string.scorpio
                tanggal < 250 -> R.string.sagiturius
                tanggal < 300 -> R.string.capricorn
                else -> R.string.salahBulan
            }
        } else {
                when {
                    tanggal < 10 -> R.string.aquarius
                    tanggal < 20 -> R.string.pisces
                    tanggal < 30 -> R.string.aries
                    tanggal < 40 -> R.string.taurus
                    tanggal < 50 -> R.string.gemini
                    tanggal < 60 -> R.string.cancer
                    tanggal < 70 -> R.string.leo
                    tanggal < 80 -> R.string.virgo
                    tanggal < 90 -> R.string.libra
                    tanggal < 100 -> R.string.scorpio
                    tanggal < 110 -> R.string.sagiturius
                    tanggal < 120 -> R.string.capricorn
                    else -> R.string.salahBulan
                }
        }
        return getString(stringRes)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(Menu.NONE, 1 , Menu.NONE, "Dark Mode")
        menu?.add(Menu.NONE, 2 , Menu.NONE, "Light Mode")
        menu?.add(Menu.NONE, 3 , Menu.NONE, "Follow by system")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
        return super.onOptionsItemSelected(item)
    }
}




