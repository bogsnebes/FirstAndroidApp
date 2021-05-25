package com.example.myapplicationtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListTrifficLights : AppCompatActivity(R.layout.activity_list_triffic_lights) {
    private var nameList: ArrayList<String> = arrayListOf(
        "Красный",
        "Желтый",
        "Зеленый"
    )
    private lateinit var trafficLightsListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        trafficLightsListView = findViewById(R.id.listView)
        trafficLightsListView.adapter =
            ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, nameList)

        trafficLightsListView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Сэлам Уалейкум))", Toast.LENGTH_SHORT).show()
            var intentTrafficLightImage = Intent(this, TrafficLightImage::class.java).apply {
                putExtra("positionTrafficLight", position)
            }
            startActivity(intentTrafficLightImage)
        }
    }
}