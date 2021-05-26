package com.example.myapplicationtwo

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//TODO: Может быть Traffic? :)
class ListTrifficLights : AppCompatActivity(R.layout.activity_list_triffic_lights) {
    // TODO: Вынеси в companion object *орехус*
    private var nameList: ArrayList<String> = arrayListOf(
        "Красный",
        "Желтый",
        "Зеленый"
    )
    private lateinit var trafficLightsListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: ListView никогда не используй, ты же не в 2014. Сейчас используют только RecyclerView
        trafficLightsListView = findViewById(R.id.listView)
        trafficLightsListView.adapter =
            ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, nameList)

        // TODO: Студия подчёркивает, что параметр неиспользуется и лучше вместо него сделать _, тык сделай так
        trafficLightsListView.setOnItemClickListener { parent, view, position, id ->
            // TODO: Текст выноси в values/strings, чтобы была возможность смены языка.
            //  Получать такой текст просто: getString(Id)
            Toast.makeText(this, "Сэлам Уалейкум))", Toast.LENGTH_SHORT).show()
            // TODO: TrafficLightImage createInstance()
            // TODO: Почему не val? Студия тебе же сама говорит
            var intentTrafficLightImage = Intent(this, TrafficLightImage::class.java).apply {
                // TODO: Название значения выноси в константы: private const POSITION_TRAFFIC_NAME = "..."
                putExtra("positionTrafficLight", position)
            }
            startActivity(intentTrafficLightImage)
        }
    }
}