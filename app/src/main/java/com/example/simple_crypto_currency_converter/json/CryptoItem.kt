package com.example.simple_crypto_currency_converter.json


data class CryptoItem(
    val ath: Double,                             // All-Time High price of the cryptocurrency
    val ath_change_percentage: Double,           // Percentage change from ATH
    val ath_date: String,                        // Date of the All-Time High
    val atl: Double,                             // All-Time Low price of the cryptocurrency
    val atl_change_percentage: Double,           // Percentage change from ATL
    val atl_date: String,                        // Date of the All-Time Low
    val circulating_supply: Double,              // Circulating supply of the cryptocurrency
    val current_price: Double,                   // Current price of the cryptocurrency
    val fully_diluted_valuation: Long,           // Fully diluted valuation of the cryptocurrency
    val high_24h: Double,                        // Highest price in the last 24 hours
    val id: String,                              // Unique identifier for the cryptocurrency
    val image: String,                           // URL of the cryptocurrency's logo/image
    val last_updated: String,                    // Last update timestamp
    val low_24h: Double,                         // Lowest price in the last 24 hours
    val market_cap: Long,                        // Market capitalization of the cryptocurrency
    val market_cap_change_24h: Double,           // Change in market cap in the last 24 hours
    val market_cap_change_percentage_24h: Double,// Percentage change in market cap in the last 24 hours
    val market_cap_rank: Int,                    // Rank of the cryptocurrency by market cap
    val max_supply: Double,                      // Maximum supply of the cryptocurrency
    val name: String,                            // Name of the cryptocurrency
    val price_change_24h: Double,                // Change in price in the last 24 hours
    val price_change_percentage_1h_in_currency: Double, // Percentage change in price in the last 1 hour
    val price_change_percentage_24h: Double,     // Percentage change in price in the last 24 hours
    val roi: Roi,                                // Return on Investment data for the cryptocurrency
    val symbol: String,                          // Symbol/ticker of the cryptocurrency
    val total_supply: Double,                    // Total supply of the cryptocurrency
    val total_volume: Long                       // Total trading volume in the last 24 hours
)