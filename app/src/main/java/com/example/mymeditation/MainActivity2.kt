package com.example.mymeditation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val sleep = findViewById<ImageView>(R.id.sleep)
        val yog = findViewById<ImageView>(R.id.yognidra)
        val buttony=findViewById<Button>(R.id.buttonyog)
        val buttons= findViewById<Button>(R.id.buttonsleep)
        val btnMor =findViewById<Button>(R.id.btnMorning)

        buttons.setOnClickListener {
            val intent = Intent(this@MainActivity2,SleepActivity::class.java)
            startActivity(intent)}

            buttony.setOnClickListener{
              val intent   =Intent(this@MainActivity2,YogNindraActivity::class.java)
                startActivity(intent)
            }


        btnMor.setOnClickListener{
            val intent   =Intent(this@MainActivity2,Morning::class.java)
            startActivity(intent)
        }

        }
    }
