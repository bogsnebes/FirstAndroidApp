package com.example.myapplicationtwo

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val timer: Timer = Timer()

    // TODO: Назови semaforImageView хотя бы.
    private lateinit var semafor: ImageView
    private lateinit var semaforButton: ImageButton

    private var isRun: Boolean = true
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Айдишники в layout с маленькой буквы.
        semafor = findViewById(R.id.Semafor)

        // TODO: не используй onClick и другие листенеры в xml, так уже никто не делает,
        //  вешай листенеры в OnCreate
        // Можно вот так: semafor.setOnClickListener(this::onClickStartStop)
        // А можно и вот так, так как тебе не нужно переиспользовывать:
        semafor.setOnClickListener { _ ->
            if (isRun) {
                startStop()
                semafor.setImageResource(R.drawable.button_stop)
            } else {
                // TODO: А что, зачем два раза подряд?
                semafor.setImageResource(R.drawable.button_start)
                semafor.setImageResource(R.drawable.semafor_grey)
                timer.cancel()
                counter = 0
            }

            isRun = !isRun
        }
    }

    // TODO: Метод убери, оставил его для TODO про smart cast.
    fun onClickStartStop(view: View) {
        // TODO: Делаем проеку на ImageView, а дальше используем его как объект типа ImageView
        //   прочитай про smart cast
        if (view is ImageView) {
            if (isRun) {
                startStop()
                view.setImageResource(R.drawable.button_stop)
            } else {
                view.setImageResource(R.drawable.button_start)
                semafor.setImageResource(R.drawable.semafor_grey)
                timer.cancel()
                counter = 0
            }

            isRun = !isRun
        }
    }

    // TODO: Не забывай private методы делать
    fun startStop() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    // TODO: runOnUiThread только для view, убери от сюда инкремент counter
                    semafor.setImageResource(imageArray[counter])
                    counter++
                    if (counter == 3) counter = 0

                    // TODO: counter = (counter + 1) % 3?
                }
            }
            // TODO: Delay и period в константы.
        }, TIMER_DELAY, 1000)
    }

    companion object {
        private const val TIMER_DELAY: Long = 0

        // TODO: что за image Array? Дай нормальное название, по которому можно будет понять,
        //  что это за массив))
        private val imageArray: IntArray = intArrayOf(
            R.drawable.semafor_red,
            R.drawable.semafor_yellow,
            R.drawable.semafor_green
        )
    }
}
