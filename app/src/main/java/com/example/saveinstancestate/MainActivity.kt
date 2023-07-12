package com.example.saveinstancestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var button: Button
    private lateinit var editText: EditText
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)

        button.setOnClickListener {
            count ++
            textView.text = "ЗДАРОВА: $count"
            textView2.text = "ОБЭМА"
        }


        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("KEY", 0)
            textView2.text = savedInstanceState.getString("KEY2")
            textView.text = "Число: $count"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("KEY", count)
        outState.putString("KEY2", textView2.text.toString())
        super.onSaveInstanceState(outState)
    }

}