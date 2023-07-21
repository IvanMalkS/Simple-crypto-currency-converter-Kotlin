package com.example.simple_crypto_currency_converter.json

data class Roi(
    val currency: String,   // The currency in which the ROI is calculated
    val percentage: Double, // The percentage ROI value
    val times: Double       // The ROI value expressed as a multiple
)