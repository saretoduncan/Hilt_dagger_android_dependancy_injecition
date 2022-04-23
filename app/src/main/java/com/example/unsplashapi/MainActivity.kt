package com.example.unsplashapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unsplashapi.adapter.ImageAdapter
import com.example.unsplashapi.databinding.ActivityMainBinding
import com.example.unsplashapi.viewModel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var imageAdaper: ImageAdapter
    private lateinit var binding:ActivityMainBinding
    private val viewModel:ImageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        imageAdaper= ImageAdapter()
        binding.recyclerView.apply {
            adapter= imageAdaper
            layoutManager= LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
        viewModel.responseImages.observe(this) { response ->
            if (response != null) {
                imageAdaper.submitList(response)
            }
        }
    }
}