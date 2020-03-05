package com.danieloliveira.temperature

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val temperatureArray by lazy { resources.getStringArray(R.array.temperatures_array) }
    private var temperatureOption: Int = 0
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        temperature_spinner.onItemSelectedListener = this
        btn_temperature.setOnClickListener {
            convertTemperature()
        }
    }

    private fun convertTemperature() {
        txt_temperature.text =
            viewModel.convertTemperature(
                temperatureText = edt_temperature.text.toString(),
                temperatureOption = temperatureOption
            )
    }

    override fun onNothingSelected(parent: AdapterView<*>?) = Unit

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (parent!!.getItemAtPosition(position) as String) {
            temperatureArray[0] -> temperatureOption = 0
            temperatureArray[1] -> temperatureOption = 1
            temperatureArray[2] -> temperatureOption = 2
            temperatureArray[3] -> temperatureOption = 3
        }
    }
}
