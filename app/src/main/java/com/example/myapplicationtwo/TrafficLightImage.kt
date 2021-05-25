package com.example.myapplicationtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class TrafficLightImage : AppCompatActivity(R.layout.activity_traffic_light_image) {
    private lateinit var semaforImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        semaforImageView = findViewById(R.id.imageView)
        var i = intent
        if (i != null) semaforImageView.setImageResource(semaforColorsArray[i.getIntExtra("positionTrafficLight", 0)])
    }
    companion object {
        private val semaforColorsArray: IntArray = intArrayOf(
            R.drawable.semafor_red,
            R.drawable.semafor_yellow,
            R.drawable.semafor_green
        )
    }
}