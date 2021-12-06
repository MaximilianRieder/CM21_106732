package com.rieder.phonedialapp

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.lang.RuntimeException
import android.widget.LinearLayout
import android.widget.TextView





class MainActivity : AppCompatActivity() {

    //todo instanciate other 2
    private var phoneNumber = ""
    private var quickCall1Name = ""
    private var quickCall1Number = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        //todo do for others 2
        quickCall1Name = sharedPreferences.getString("quickCall1Name", "").toString()
        quickCall1Number = sharedPreferences.getString("quickCall1Number", "").toString()
        val textView: TextView = findViewById<TextView>(R.id.quick_text_1)
        textView.text = quickCall1Name

        val quick_button_1 = findViewById<Button>(R.id.quick_button_1)
        quick_button_1.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                showQuickDialog(1)
                return true
            }
        })
        quick_button_1.setOnClickListener {
            Log.i("asd", "Long2")
        }
    }

    //todo write function for quick dial

    fun showQuickDialog(forQuickSave :Int) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Quickdial")

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val inputName = EditText(this)
        inputName.setHint("Enter name")
        inputName.inputType = InputType.TYPE_CLASS_TEXT
        layout.addView(inputName)

        val inputNumber = EditText(this)
        inputNumber.setHint("Enter phone number")
        inputNumber.inputType = InputType.TYPE_CLASS_PHONE
        layout.addView(inputNumber)
        builder.setView(layout)

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            setNameNumberForQuick(forQuickSave, inputName.text.toString(), inputNumber.text.toString())
        })
        builder.setNegativeButton(
            "Cancel",
            DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        builder.show()
    }

    //todo do for the other 2
    fun setNameNumberForQuick(forIndex :Int, name :String, number :String) {
        var sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        when(forIndex) {
            1 -> {
                quickCall1Name = name
                quickCall1Number = number
                val textView: TextView = findViewById<TextView>(R.id.quick_text_1)
                textView.text = name
                with (sharedPreferences.edit()) {
                    putString("quickCall1Name", name)
                    putString("quickCall1Number", number)
                    apply()
                }
            }
            2 -> {

            }
            3 -> {

            }
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