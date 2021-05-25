package com.example.myapplicationtwo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var semaforImageView: ImageView
    private lateinit var semaforButton: ImageButton
    private lateinit var listButton: Button

    private var isRun: Boolean = true
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        semaforImageView = findViewById(R.id.semafor)
        semaforButton = findViewById(R.id.imageButton)
        listButton = findViewById(R.id.button)

        semaforButton.setOnClickListener { _ ->
            if (semaforButton is ImageView) {
                if (isRun) {
                    startStop()
                    semaforButton.setImageResource(R.drawable.button_stop)
                } else {
                    semaforButton.setImageResource(R.drawable.button_start)
                    semaforImageView.setImageResource(R.drawable.semafor_grey)
                    timer.cancel()
                    counter = 0
                }

                isRun = !isRun
            }
        }

        listButton.setOnClickListener { _ ->
            val intent = Intent(this, ListTrifficLights::class.java)
            startActivity(intent)
        }
    }


    private fun startStop() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    semaforImageView.setImageResource(semaforColorsArray[counter])
                    counter++
                    if (counter == 3) counter = 0
                }
            }
        }, TIMER_DELAY, TIMER_PERIOD)
    }

    companion object {
        private val timer: Timer = Timer()
        private const val TIMER_DELAY: Long = 0
        private const val TIMER_PERIOD: Long = 1000

        private val semaforColorsArray: IntArray = intArrayOf(
            R.drawable.semafor_red,
            R.drawable.semafor_yellow,
            R.drawable.semafor_green
        )
    }
}