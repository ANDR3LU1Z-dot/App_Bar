package com.example.appbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = binding.toolbar

        setContentView(binding.root)

        //Necessário para Manipular a Toolbar
        setSupportActionBar(toolbar)

//        supportActionBar?.title = "Outro Texto"
        supportActionBar?.setLogo(R.drawable.ic_logo)
        supportActionBar?.setDisplayUseLogoEnabled(true)


        val buttonMain = binding.btnStartSecondActivity

        buttonMain.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }


    }


}