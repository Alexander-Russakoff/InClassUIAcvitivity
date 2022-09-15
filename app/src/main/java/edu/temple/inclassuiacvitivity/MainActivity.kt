package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val changeButton = findViewById<Button>(R.id.changeButton)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)
        var textSize = 22f
        // Step 1: Populate array
        val numberArray = IntArray(100)

        for (i in numberArray.indices){
            numberArray[i]=i

        }

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numberArray.asList())


        // Step 2: Save selected text size
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                textSize = position.toFloat()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Step 3: Change TextView to saved text size
        changeButton.setOnClickListener {
            displayTextView.textSize = textSize
        }

    }
}
