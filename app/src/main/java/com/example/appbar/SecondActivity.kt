package com.example.appbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.appbar.databinding.ActivityMainBinding
import com.example.appbar.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

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

    //Para criar o menu na tela e vincular ele a essa activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_screen_menu, menu)
        return true
    }

    //Para manipular os clicks nos itens selcionados no menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_save -> {
                Snackbar.make(
                    this,
                    binding.root,
                    getString(R.string.menu_save_title),
                    Snackbar.LENGTH_SHORT
                ).show()
                true
            }

            R.id.menu_settings -> {
                Snackbar.make(
                    this,
                    binding.root,
                    getString(R.string.menu_settings_title),
                    Snackbar.LENGTH_SHORT
                ).show()
                true
            }
            else -> false
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        onBackPressed()
//        return true
//    }
}