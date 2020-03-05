package com.danieloliveira.temperature

import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityViewModel : ViewModel() {

    fun convertTemperature(temperatureText: String, temperatureOption: Int): String {
        var converted = 0.0
        return if (temperatureText != "") {
            when (temperatureOption) {
                0 -> converted = celsiusToKelvin(temperatureText.toInt())
                1 -> converted = celsiusToFahrenheit(temperatureText.toInt()).toDouble()
                2 -> converted = celsiusToReaumur(temperatureText.toInt()).toDouble()
                3 -> converted = celsiusToRankine(temperatureText.toInt())
            }
            "Sua temperatura é $converted"
        } else ""
    }

    private fun celsiusToKelvin(temperature: Int) = temperature + 273.15

    private fun celsiusToFahrenheit(temperature: Int) = (temperature * 9 / 5) + 32

    private fun celsiusToReaumur(temperature: Int) = temperature * 4 / 5

    private fun celsiusToRankine(temperature: Int) = temperature * 9 / 5 + 491.67
}