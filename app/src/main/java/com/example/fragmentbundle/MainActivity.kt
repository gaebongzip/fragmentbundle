package com.example.fragmentbundle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragTra = supportFragmentManager.beginTransaction()
        val one = OneFragment()
        fragTra.replace(R.id.frameLayout, one)
        fragTra.commit()

    }
}