package com.example.myapplicationtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

// TODO: Замени плиз на фрагменты
class TrafficLightImage : AppCompatActivity(R.layout.activity_traffic_light_image) {
    private lateinit var semaforImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        semaforImageView = findViewById(R.id.imageView)

        // TODO: val, а лучше сделай как снизу
        var i = intent
        if (i != null) semaforImageView.setImageResource(semaforColorsArray[i.getIntExtra("positionTrafficLight", 0)])

        // TODO: if (i != null) эквивалентен intent?.
        // Но так как у тебя тут он внутри используется, делают так:
        // TODO: let это отображание объекта в другой объект: x это Button
        //  x.let{ button -> button as ImageButton}, теперь x ImageButton,
    //      если использовать оператор ?., то если x будет null, то просто ничего не выполнится.
/*        intent?.let {
            semaforImageView.setImageResource(getSemaforColor())
        }*/
        // Плиз не делай такую вложенность, сложно разобрать, можно ведь декомпозировать в отедьный метод
        // ну и Name нужно переиспользовать из companionObject у ListTrafficLights
    }
    companion object {
        private val semaforColorsArray: IntArray = intArrayOf(
            R.drawable.semafor_red,
            R.drawable.semafor_yellow,
            R.drawable.semafor_green
        )
    }
}