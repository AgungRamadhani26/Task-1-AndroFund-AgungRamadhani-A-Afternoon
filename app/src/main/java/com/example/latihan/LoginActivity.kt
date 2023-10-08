package com.example.latihan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FillEventHistory
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    //Deklarasi tipe dari variabel
    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var history: TextView

    val resultLauncer = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if(result.resultCode == Activity.RESULT_OK){
            val data:Intent? = result.data
            val returnString:String? = data?.getStringExtra("history")
            history.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //assign variabel yang sudah di Deklarasi
        etUsername = findViewById(R.id.edit_username)
        etPassword = findViewById(R.id.edit_password)
        history = findViewById(R.id.history)

        val bundle = intent.extras
        //jika bundle berisi data / tidak kosong maka akan menampilkan data username dan password pada halaman login
        if (bundle != null){
            etUsername.setText(bundle.getString("username"))//diambil dari intent dihalaman register dengan key username
            etPassword.setText(bundle.getString("password"))
        }

        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_login -> {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                //Mengirim data dengan bantuan parcelize, menggunakan putExtra karena data yang dikirim
                //dijadikan 1 data class yaitu user, sehingga tidak perlu menggunakan putExtras
                intent.putExtra("User", User(etUsername.text.toString(), etPassword.text.toString()))
                //dari startintent diubah ke result launcer karena kita mengirim data ke activity tujuan yaitu
                //main activity lalu result dari main activity dikirim kembali ke activity ini yaitu login activity
                resultLauncer.launch(intent)
            }
        }
    }
}