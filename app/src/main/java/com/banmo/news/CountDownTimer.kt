package com.banmo.news

import android.os.Handler


class CountDownTimer(iCountDown: ICountDown, private var time: Int) {
    private var finished = false

    init {
        finished = false
    }

    private val handler = Handler{
        if(time>=0){
            time--
            iCountDown.flushView(time.toString())
            postDelay1()

        }else{
            iCountDown.flushView("跳过")
            finished = true
        }
        true
    }

    private fun postDelay1(){
        handler.sendEmptyMessageDelayed(0,1000)
    }

    fun start(){
        handler.sendEmptyMessage(0)
    }

    fun isFinished(): Boolean {
        return finished
    }

    interface ICountDown {
        fun flushView(string: String)
    }

}