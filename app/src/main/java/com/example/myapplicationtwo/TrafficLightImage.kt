package com.example.myapplicationtwo

import android.content.Context
import android.content.Intent
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

        fun createInstance(context: Context, POSITION_TRAFFIC_NAME: String, position: Int): Intent {
            return Intent(context, TrafficLightImage::class.java).apply {
                this.putExtra(POSITION_TRAFFIC_NAME, position)
            }
        }
    }
}