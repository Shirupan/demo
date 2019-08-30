package com.stone.checkin_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.stone.cheakin.widget.CheakInLinstener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        checkIn.initCheakDays(arrayListOf(1,2,3,4,5,6,7,24))//设置已签到日期
//        checkIn.cheakInDays(31)//按日期签到

        checkIn.setCheckInLinstener(object : CheakInLinstener {
            override fun onSuccess(day: Int) {
                Log.d("test", "onSuccess:"+day)
                Toast.makeText(this@MainActivity, "签到成功", Toast.LENGTH_SHORT).show()
            }

            override fun onChecked(day: Int) {
                Log.d("test", "onChecked:"+day)
                Toast.makeText(this@MainActivity, "已签到", Toast.LENGTH_SHORT).show()
            }
        })

        btnCheak.setOnClickListener{
            checkIn.cheakInToday()//当天签到
        }
    }
}
