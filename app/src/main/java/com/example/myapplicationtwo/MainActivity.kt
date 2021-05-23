package com.example.myapplicationtwo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var counter: Int = 0
    private var text: String = "PopkaAss $counter"

    private var cLayout: ConstraintLayout? = null
    private lateinit var tvText: TextView

    private var start: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvText = findViewById(R.id.tvText)
        tvText.text = text

        Thread {
            while (start) {
                Thread.sleep(5000)
                runOnUiThread {
                    tvText.text = counter.toString()
                    if (counter == 5) {
                        cLayout = findViewById(R.id.cLayout)
                        cLayout?.setBackgroundColor(Color.BLACK)
                        tvText.setHintTextColor(Color.WHITE)
                        start = false
                    }
                    counter++
                }
            }
        }.start()
    }
}