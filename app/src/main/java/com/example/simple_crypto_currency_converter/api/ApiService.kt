package com.example.simple_crypto_currency_converter.api

import com.example.simple_crypto_currency_converter.json.CryptoItem
import retrofit2.http.GET

// The ApiService interface defines the API endpoints and their respective HTTP methods.
interface ApiService {
    // @GET annotation specifies that this function performs an HTTP GET request.
    // The path inside the annotation indicates the relative endpoint of the API.
    // The query parameters are appended to the URL for filtering and paginating data.
    // The suspend keyword indicates that this function can be called from a coroutine.
    @GET("api/v3/coins/markets?vs_currency=usd" +
            "&order=market_cap_desc" +
            "&per_page=50&page=1" +
            "&sparkline=false" +
            "&price_change_percentage=1h" +
            "&locale=en")
    suspend fun getCrypto(): List<CryptoItem>
}