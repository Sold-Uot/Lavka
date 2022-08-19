package com.example.lavka.mvp.Helper

import android.util.Log

class Helper {
    companion object{
        @JvmStatic
        fun log(tag: String="",string: String){
            Log.e(tag,string)
        }
    }
}