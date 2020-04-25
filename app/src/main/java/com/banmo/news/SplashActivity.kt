package com.banmo.news

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*
import java.io.File

class SplashActivity : AppCompatActivity() {

    private val countDownTimer = CountDownTimer(object : CountDownTimer.ICountDown {
        override fun flushView(string: String) {
            tv_timer.text = string
        }
    }, 5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initSplash()
        initTimer()
    }

    private fun initSplash() {
        vv_splash.setVideoURI(Uri.parse("android.resource://" + packageName + File.separator + R.raw.splash))
        vv_splash.setOnPreparedListener {
            it.start()
        }
        vv_splash.setOnCompletionListener {
            it.start()
        }
    }

    private fun initTimer() {
        countDownTimer.start()
        tv_timer.setOnClickListener {
            if (countDownTimer.isFinished()) vv_splash.pause()
        }
    }

}
