package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.latihan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //Deklarasi tipe dari variabel
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //assign variabel yang sudah di Deklarasi
        tv = findViewById(R.id.textView2)

        //mendapatkan data yang sudah menggunakan parcelize/parcelable
        val usernamee = intent.getParcelableExtra<User>("User")?.username
        val password = intent.getParcelableExtra<User>("User")?.password

        //Menampilkan data ke halaman main
        tv.text = "Kamu Login Sebagai\n\nUsername: $usernamee\nPassword: $password"

        val btnInplicit: Button = findViewById(R.id.btn_implicit)
        btnInplicit.setOnClickListener(this)

        val btnPermainan: Button = findViewById(R.id.btn_permainan)
        btnPermainan.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            // utk intent implicit
            R.id.btn_implicit -> {
                //val message = "Hallo"
                //val intent = Intent()
                //intent.action = Intent.ACTION_SEND
                //intent.putExtra(Intent.EXTRA_TEXT, message)
                //intent.type = "text/plain"
                //startActivity(intent)
                val intent = Intent()
                intent.putExtra("history", "Anda Sudah Login")
                setResult(RESULT_OK, intent)
                finish()
            }

            R.id.btn_permainan -> {
                val intent = Intent(this@MainActivity, PermainanUbahBacground::class.java)
                startActivity(intent)
            }
        }
    }
}