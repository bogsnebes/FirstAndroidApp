package com.example.myapplicationtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

// TODO: Замени плиз на фрагменты
class TrafficLightImage : AppCompatActivity(R.layout.activity_traffic_light_image) {
    private lateinit var trafficLightsImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        trafficLightsImageView = findViewById(R.id.imageView)

        intent?.let {
            trafficLightsImageView.setImageResource(
                trafficLightsColorsArray[intent.getIntExtra(
                    "positionTrafficLight",
                    0
                )]
            )
        }

        // ну и Name нужно переиспользовать из companionObject у ListTrafficLights
        // ANSWER: Там словечки, просто название цвета. "Красный", "Желтый", "Зеленый"
    }

    companion object {
        private val trafficLightsColorsArray: IntArray = intArrayOf(
            R.drawable.semafor_red,
            R.drawable.semafor_yellow,
            R.drawable.semafor_green
        )
    }
}