package com.example.saveandrestore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val KEY_DATA = "DATA"
    val KEY_APP_OPEN = "APP_OPEN"
    var appOpenCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sPref = getPreferences(Context.MODE_PRIVATE)

        appOpenCount = sPref.getInt(KEY_APP_OPEN, 0)
        appOpenCount++

        sPref.edit {
            putInt(KEY_APP_OPEN,appOpenCount)
        }

        tvOpenCount.text = "Count = ${appOpenCount}".toString()

        btnSave.setOnClickListener {
            sPref.edit {
                putString(KEY_DATA,etData.text.toString())
            }
        }

        btnRestore.setOnClickListener {
            etData.setText(sPref.getString(KEY_DATA, ""))
        }

    }
}
