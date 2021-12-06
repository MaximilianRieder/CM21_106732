package com.rieder.phonedialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import java.lang.RuntimeException


class MainActivity : AppCompatActivity() {

    private var phoneNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun addToNumber(view: View) {
        when (view.id) {
            R.id.button_0 -> {
                phoneNumber += 0
            }
            R.id.button_1 -> {
                phoneNumber += 1
            }
            R.id.button_2 -> {
                phoneNumber += 2
            }
            R.id.button_3 -> {
                phoneNumber += 3
            }
            R.id.button_4 -> {
                phoneNumber += 4
            }
            R.id.button_5 -> {
                phoneNumber += 5
            }
            R.id.button_6 -> {
                phoneNumber += 6
            }
            R.id.button_7 -> {
                phoneNumber += 7
            }
            R.id.button_8 -> {
                phoneNumber += 8
            }
            R.id.button_9 -> {
                phoneNumber += 9
            }
            R.id.button_back -> {
                phoneNumber = phoneNumber.dropLast(1)
            }
            else -> throw RuntimeException("Unknow button ID")
        }
        Log.i("asd", phoneNumber)
    }
}