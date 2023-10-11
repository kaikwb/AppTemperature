package br.com.fiap.apptemperature

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBar = findViewById<SeekBar>(R.id.temperatureSeekBar)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
                temperatureChange(seekBar)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                temperatureChange(seekBar!!)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                temperatureChange(seekBar!!)
            }
        })
        temperatureChange(seekBar)
    }

    fun temperatureChange(seekBar: SeekBar) {
        val kelvinTemperature = seekBar.progress
        val celsiusTemperature = kelvinTemperature - 273
        val fahrenheitTemperature = (celsiusTemperature * 1.8) + 32

        val kelvinTextView = findViewById<TextView>(R.id.kelvinTextView)
        kelvinTextView.text = "$kelvinTemperature K"

        val celsiusTextView = findViewById<TextView>(R.id.celsiusTextView)
        celsiusTextView.text = "$celsiusTemperature ºC"

        val fahrenheitTextView = findViewById<TextView>(R.id.fahrenheitTextView)
        fahrenheitTextView.text = "${"%.2f".format(fahrenheitTemperature)} ºF"
    }
}