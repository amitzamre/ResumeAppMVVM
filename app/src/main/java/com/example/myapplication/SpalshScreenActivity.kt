package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpalshScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh_screen)



        Handler().postDelayed({
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}