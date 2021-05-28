package com.example.myapplicationtwo

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var trafficLightsImageView: ImageView
    private lateinit var trafficLightsButton: ImageButton
    private lateinit var listButton: Button

    private var isRun: Boolean = true
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        trafficLightsImageView = findViewById(R.id.semafor)
        trafficLightsButton = findViewById(R.id.imageButton)
        listButton = findViewById(R.id.button)

        trafficLightsButton.setOnClickListener {
            if (isRun) {
                startStop()
                trafficLightsButton.setImageResource(R.drawable.button_stop)
            } else {
                trafficLightsButton.setImageResource(R.drawable.button_start)
                trafficLightsImageView.setImageResource(R.drawable.semafor_grey)
                timer.cancel()
                counter = 0
            }

            isRun = !isRun
        }

        listButton.setOnClickListener {
            val intent = ListTrafficLights.createInstance(this)
            startActivity(intent)
        }
    }


    private fun startStop() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    trafficLightsImageView.setImageResource(trafficLightsColorsArray[counter])
                    counter++
                    if (counter == 3) counter = 0
                }
            }
        }, TIMER_DELAY, TIMER_PERIOD)
    }

    companion object {
        val timer = Timer()

        private const val TIMER_DELAY: Long = 0
        private const val TIMER_PERIOD: Long = 1000

        private val trafficLightsColorsArray: IntArray = intArrayOf(
            R.drawable.semafor_red,
            R.drawable.semafor_yellow,
            R.drawable.semafor_green
        )

    }
}