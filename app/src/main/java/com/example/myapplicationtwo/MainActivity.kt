package com.example.myapplicationtwo

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var semafor: ImageView
    private lateinit var semaforButton: ImageButton
    private lateinit var timer: Timer

    private var imageArray: IntArray = intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)

    private var isRun: Boolean = true
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        semafor = findViewById(R.id.Semafor)
    }

    fun onClickStartStop(view: View) {
        view as ImageView
        if (isRun) {
            startStop()
            view.setImageResource(R.drawable.button_stop)
            isRun = false
        }
        else {
            view.setImageResource(R.drawable.button_start)
            semafor.setImageResource(R.drawable.semafor_grey)
            isRun = true
            timer.cancel()
            counter = 0
        }
    }

    fun startStop() {
        timer = Timer()
        timer.schedule(object :TimerTask() {
            override fun run() {
            runOnUiThread {
                semafor.setImageResource(imageArray[counter])
                counter++
                if (counter == 3) counter = 0
            }
            }
        }, 0, 1000)
    }
}