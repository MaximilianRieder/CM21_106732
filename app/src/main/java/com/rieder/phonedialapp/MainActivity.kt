package com.rieder.phonedialapp

import android.app.AlertDialog
import android.content.Context
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

    private var phoneNumber = ""
    private var quickCall1Name = ""
    private var quickCall1Number = ""
    private var quickCall2Name = ""
    private var quickCall2Number = ""
    private var quickCall3Name = ""
    private var quickCall3Number = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get data from db
        val sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        quickCall1Name = sharedPreferences.getString("quickCall1Name", "").toString()
        quickCall1Number = sharedPreferences.getString("quickCall1Number", "").toString()
        val textView1: TextView = findViewById<TextView>(R.id.quick_text_1)
        textView1.text = quickCall1Name + "\n" + quickCall1Number
        quickCall2Name = sharedPreferences.getString("quickCall2Name", "").toString()
        quickCall2Number = sharedPreferences.getString("quickCall2Number", "").toString()
        val textView2: TextView = findViewById<TextView>(R.id.quick_text_2)
        textView2.text = quickCall2Name + "\n" + quickCall2Number
        quickCall3Name = sharedPreferences.getString("quickCall3Name", "").toString()
        quickCall3Number = sharedPreferences.getString("quickCall3Number", "").toString()
        val textView3: TextView = findViewById<TextView>(R.id.quick_text_3)
        textView3.text = quickCall3Name + "\n" + quickCall3Number

        //actions for buttons
        val quick_button_1 = findViewById<Button>(R.id.quick_button_1)
        quick_button_1.setOnLongClickListener {
            showQuickDialog(1)
            true
        }
        val quick_button_2 = findViewById<Button>(R.id.quick_button_2)
        quick_button_2.setOnLongClickListener {
            showQuickDialog(2)
            true
        }
        val quick_button_3 = findViewById<Button>(R.id.quick_button_3)
        quick_button_3.setOnLongClickListener {
            showQuickDialog(3)
            true
        }
    }

    fun quickCall(view: View) {
        when (view.id) {
            R.id.quick_button_1 -> {
                Log.i("asd", "asnkfjkasjfjasfoi")
                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:$quickCall1Number")
                )
                startActivity(intent)
            }
            R.id.quick_button_2 -> {
                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:$quickCall2Number")
                )
                startActivity(intent)
            }
            R.id.quick_button_3 -> {
                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:$quickCall3Number")
                )
                startActivity(intent)
            }
            else -> throw RuntimeException("Unknow button ID")
        }
    }

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

        builder.setPositiveButton("OK") { _, _ ->
            setNameNumberForQuick(
                forQuickSave,
                inputName.text.toString(),
                inputNumber.text.toString()
            )
        }
        builder.setNegativeButton(
            "Cancel"
        ) { dialog, _ -> dialog.cancel() }

        builder.show()
    }

    fun setNameNumberForQuick(forIndex :Int, name :String, number :String) {
        val sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        when(forIndex) {
            1 -> {
                quickCall1Name = name
                quickCall1Number = number
                val textView: TextView = findViewById<TextView>(R.id.quick_text_1)
                textView.text = name + "\n" + number
                with (sharedPreferences.edit()) {
                    putString("quickCall1Name", name)
                    putString("quickCall1Number", number)
                    apply()
                }
            }
            2 -> {
                quickCall2Name = name
                quickCall2Number = number
                val textView: TextView = findViewById<TextView>(R.id.quick_text_2)
                textView.text = name + "\n" + number
                with (sharedPreferences.edit()) {
                    putString("quickCall2Name", name)
                    putString("quickCall2Number", number)
                    apply()
                }
            }
            3 -> {
                quickCall3Name = name
                quickCall3Number = number
                val textView: TextView = findViewById<TextView>(R.id.quick_text_3)
                textView.text = name + "\n" + number
                with (sharedPreferences.edit()) {
                    putString("quickCall3Name", name)
                    putString("quickCall3Number", number)
                    apply()
                }
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