package com.aldimas.kisahnabiapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldimas.kisahnabiapp.R
import com.aldimas.kisahnabiapp.data.KisahResponse
import com.aldimas.kisahnabiapp.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val kisah = intent.getParcelableExtra<KisahResponse>(EXTRA_DATA)

        kisah?.let {
            binding.apply {
                detailNama.text = kisah.name
                detailDesk.text = kisah.description
                detailTahun.text = kisah.thnKelahiran
                detailTempat.text = kisah.tmp
                detailUsia.text = kisah.usia
                Glide.with(this@DetailActivity).load(kisah.imageUrl).into(detailImage)
            }
        }
    }
    companion object {
        const val EXTRA_DATA = "data"
    }
}