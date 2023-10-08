package com.example.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.latihan.databinding.ActivityMainBinding
import com.example.latihan.databinding.ActivityPermainanUbahBacgroundBinding

class PermainanUbahBacground : AppCompatActivity() {
    //Untuk Fragment
    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityPermainanUbahBacgroundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permainan_ubah_bacground)

        //utk fragment
        binding = ActivityPermainanUbahBacgroundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragment1.setOnClickListener{
            goToFragment(Fragment_1())
        }
        binding.btnFragment2.setOnClickListener{
            goToFragment(Fragment_2())
        }
    }

    private fun goToFragment(fragment: Fragment){
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}