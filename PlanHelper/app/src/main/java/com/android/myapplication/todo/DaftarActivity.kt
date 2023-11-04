package com.android.myapplication.todo

import android.content.ContentValues
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DaftarActivity : AppCompatActivity() {
    var TxUsername: EditText? = null
    var TxPassword: EditText? = null
    var TxConPassword: EditText? = null
    var BtnRegister: Button? = null
    var dbHelper: DBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)
        dbHelper = DBHelper(this)
        TxUsername = findViewById<View>(R.id.txUsernameReg) as EditText
        TxPassword = findViewById<View>(R.id.txPasswordReg) as EditText
        TxConPassword = findViewById<View>(R.id.txConPassword) as EditText
        BtnRegister = findViewById<View>(R.id.btnRegister) as Button
        val tvRegister = findViewById<View>(R.id.tvRegister) as TextView
        tvRegister.text = fromHtml(
            "Back to " +
                    "</font><font color='#3b5998'>Login</font>"
        )
        tvRegister.setOnClickListener {
            startActivity(
                Intent(
                    this@DaftarActivity,
                    LoginActivity::class.java
                )
            )
        }
        BtnRegister!!.setOnClickListener {
            val username = TxUsername!!.text.toString().trim { it <= ' ' }
            val password = TxPassword!!.text.toString().trim { it <= ' ' }
            val conPassword =
                TxConPassword!!.text.toString().trim { it <= ' ' }
            val values = ContentValues()
            if (password != conPassword) {
                Toast.makeText(this@DaftarActivity, "Password not match", Toast.LENGTH_SHORT)
                    .show()
            } else if (password == "" || username == "") {
                Toast.makeText(
                    this@DaftarActivity,
                    "Username or Password cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                values.put(DBHelper.row_username, username)
                values.put(DBHelper.row_password, password)
                dbHelper!!.insertData(values)
                Toast.makeText(this@DaftarActivity, "Register successful", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
        }
    }

    companion object {
        fun fromHtml(html: String?): Spanned {
            val result: Spanned
            result = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
            } else {
                Html.fromHtml(html)
            }
            return result
        }
    }
}