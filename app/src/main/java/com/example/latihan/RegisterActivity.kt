package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    //Deklarasi tipe dari variabel
    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var etConfirmPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //assign variabel yang sudah di Deklarasi
        etUsername = findViewById(R.id.edit_username)
        etPassword = findViewById(R.id.edit_password)
        etConfirmPassword = findViewById(R.id.edit_confirm_password)

        val btnRegister: Button = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_register -> {
                //Inisialisasi variabel bundel dengan class Bundle()
                val bundle = Bundle()
                //Putstring berisi key dan value yang akan dikirim, .text berguna untuk mengambil text yang
                // ada pada variable etUsername, dan .toString() berguna untuk mengubahnya kedalam bentuk string
                bundle.putString("username", etUsername.text.toString())
                bundle.putString("password", etPassword.text.toString())

                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                //Menggunakan putExtras bukan putExtra karena bundle berisi lebih dari satu data
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}