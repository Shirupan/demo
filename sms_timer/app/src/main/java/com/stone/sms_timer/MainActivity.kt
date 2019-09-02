package com.stone.sms_timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var smsCd = SSMSCountDown(tv_sms, 1000*60*2, 1000)
        tv_sms.setOnClickListener{
            smsCd.start()
        }
    }
}
