package com.example.employeerecords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast



class MainActivity : AppCompatActivity() {





    private lateinit var preferencesProvider: PreferencesProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferencesProvider = PreferencesProvider(applicationContext)

        val buttonSave :Button =  findViewById(R.id.buttonSave)
        val buttonLoad :Button = findViewById(R.id.buttonLoad)
        val buttonClear :Button = findViewById(R.id.buttonClear)
        val inputFirstName: TextView = findViewById(R.id.inputFirstName)
        val inputLastName: TextView = findViewById(R.id.inputLastName)
        val inputAge: TextView = findViewById(R.id.inputAge)
        val inputPost: TextView = findViewById(R.id.inputPost)


        buttonSave.setOnClickListener {
            preferencesProvider.putString(Constants.KEY_FIRST_NAME, inputFirstName.toString())
            preferencesProvider.putString(Constants.KEY_LAST_NAME, inputLastName.toString())
            preferencesProvider.putInt(Constants.KEY_AGE, inputAge.toString().toInt())
            preferencesProvider.putString(Constants.KEY_POST, inputPost.toString())
            preferencesProvider.putBoolean(
                Constants.KEY_REVIEW,
                R.id.radioGroup == R.id.radioButtonYes)
            Toast.makeText(applicationContext, "Data Saved",Toast.LENGTH_SHORT).show()
        }
        buttonLoad.setOnClickListener {
            inputFirstName.setText(preferencesProvider.getString(Constants.KEY_FIRST_NAME))
            inputLastName.setText(preferencesProvider.getString(Constants.KEY_FIRST_NAME))
            inputAge.setText(preferencesProvider.getInt(Constants.KEY_FIRST_NAME))
            inputPost.setText(preferencesProvider.getString(Constants.KEY_FIRST_NAME))

            Toast.makeText(applicationContext, "Data Retrieved",Toast.LENGTH_SHORT).show()
        }
        buttonClear.setOnClickListener{
            preferencesProvider.clear()
            Toast.makeText(applicationContext, "Data Cleared",Toast.LENGTH_SHORT).show()
        }

    }
}