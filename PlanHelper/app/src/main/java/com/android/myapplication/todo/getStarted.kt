package com.android.myapplication.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_get_started.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class getStarted : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        button5.setOnClickListener{
            val go = Intent(this@getStarted,DaftarActivity::class.java)

            startActivity(go)
        }

        button4.setOnClickListener{
            val go = Intent(this@getStarted,LoginActivity::class.java)

            startActivity(go)
        }
    }
}