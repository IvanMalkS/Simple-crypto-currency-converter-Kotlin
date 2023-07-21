package com.example.simple_crypto_currency_converter


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simple_crypto_currency_converter.adapters.CryptoAdapter
import com.example.simple_crypto_currency_converter.api.ApiService
import com.example.simple_crypto_currency_converter.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: CryptoAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the RecyclerView adapter and set it to the RecyclerView
        adapter = CryptoAdapter()
        binding.rcView.layoutManager = LinearLayoutManager(this)
        binding.rcView.adapter = adapter

        // Create an HTTP logging interceptor to log API requests and responses
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        // Create an OkHttpClient with the logging interceptor
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        // Create a Retrofit instance to make API calls
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/") // Base URL of the API
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create an instance of the ApiService using the Retrofit instance
        val mainApi = retrofit.create(ApiService::class.java)

        // Set a click listener to fetch data from the API when the FetchData button is clicked
        binding.FetchData.setOnClickListener() {
            // Use CoroutineScope to perform asynchronous network call
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    // Fetch data from the API using the mainApi instance
                    val list = mainApi.getCrypto()

                    // Update the RecyclerView on the main thread with the fetched data
                    runOnUiThread {
                        adapter.submitList(list)
                    }
                } catch (e: Exception) {
                    // Handle any errors that occur during the API call
                    runOnUiThread {
                        Toast.makeText(
                            this@MainActivity,
                            "Error fetching data: ${e.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}