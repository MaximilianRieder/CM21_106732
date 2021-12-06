package com.rieder.phonedialapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.lang.RuntimeException


class MainActivity : AppCompatActivity() {

    private var phoneNumber = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quick_button_1 = findViewById<Button>(R.id.quick_button_1)
        quick_button_1.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                //Snackbar.make(root_layout, "long click", Snackbar.LENGTH_LONG).show()
                Log.i("asd", "Long")
                return true  }
        })
        quick_button_1.setOnClickListener {
            Log.i("asd", "Long2")
        }
    }

    fun call(view: View) {
        val intent = Intent(
            Intent.ACTION_DIAL,
            Uri.parse("tel:$phoneNumber")
        )
        startActivity(intent)
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