package com.example.vant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        Thread.sleep(2000)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baton1 = findViewById<Button>(R.id.button)
        baton1.setOnClickListener{
            startActivity(Intent(this,MainReproductor::class.java))
        }
        





    }
}