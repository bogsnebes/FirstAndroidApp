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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvText = findViewById(R.id.tvText)
        val subText_1: String = text.substringAfter('a')
        val subText_2: String = subText_1.substringBefore(' ')
        tvText.text = subText_2

        Thread {
            while (counter < 5) {
                Thread.sleep(5000)
                runOnUiThread {
                    tvText.text = counter.toString()
                    if (counter == 5) {
                        cLayout = findViewById(R.id.cLayout)
                        cLayout?.setBackgroundColor(Color.BLACK)
                        tvText.setHintTextColor(Color.WHITE)
                    }
                    counter++
                }
            }
        }.start()
    }
}