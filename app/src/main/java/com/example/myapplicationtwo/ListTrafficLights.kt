package com.example.myapplicationtwo

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ListTrafficLights : AppCompatActivity(R.layout.activity_list_triffic_lights) {
    private lateinit var trafficLightsListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        trafficLightsListView = findViewById(R.id.listView)
        trafficLightsListView.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList)

        trafficLightsListView.setOnItemClickListener { _, _, position, _ ->
            // TODO: Текст выноси в values/strings, чтобы была возможность смены языка.
            //  Получать такой текст просто: getString(Id)
            Toast.makeText(this, "Сэлам Уалейкум))", Toast.LENGTH_SHORT).show()
            // TODO: TrafficLightImage createInstance()
            val intentTrafficLightImage = Intent(this, TrafficLightImage::class.java).apply {
                putExtra(POSITION_TRAFFIC_NAME, position)
            }
            startActivity(intentTrafficLightImage)
        }
    }

    companion object {
        private const val POSITION_TRAFFIC_NAME: String = "positionTrafficLight"
        private val nameList: ArrayList<String> = arrayListOf(
            "Красный",
            "Желтый",
            "Зеленый"
        )

//        fun createInstace() {
//            return Intent(this, ListTrafficLights::class.java)
//        }
    }
}