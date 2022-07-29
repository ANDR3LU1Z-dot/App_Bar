package com.example.appbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appbar.databinding.ActivityMainBinding
import com.example.appbar.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val toolbar2 = binding.toolbar
        setContentView(binding.root)
        setSupportActionBar(toolbar2)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val buttonSecondActivity = binding.btnBacktoMain

        buttonSecondActivity.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        onBackPressed()
//        return true
//    }
}