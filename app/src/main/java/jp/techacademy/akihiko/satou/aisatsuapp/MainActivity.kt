package jp.techacademy.akihiko.satou.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    private fun showTimePickerDialog(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                Hello(hour,minute)
            },
            13, 0, true)
        timePickerDialog.show()
    }

    private fun Hello(hour: Int,minute: Int){
        var time = (hour * 100) + minute
        if( 200 <= time && time <= 959 ){
            textView.text = "おはよう"
        } else if( 1000 <= time && time <= 1759 ){
            textView.text = "こんにちは"
        } else if( 1800 <= time || time <= 159 ){
            textView.text = "こんばんは"
        }
    }



}
