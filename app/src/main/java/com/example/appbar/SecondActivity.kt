package com.example.appbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.appbar.databinding.ActivityMainBinding
import com.example.appbar.databinding.ActivitySecondBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val toolbar2 = binding.toolbar

        setContentView(binding.root)
        setSupportActionBar(toolbar2)

        setupToolbar()

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNav



        backtoFirstActivity()
        setupDrawer()
        setupBottomNavigation()

    }

    private fun setupBottomNavigation(){
        bottomNav.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_option_1 -> {
                    Snackbar.make(drawer,getString(R.string.bottom_nav_title_1), Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.bottom_option_2 -> {
                    Snackbar.make(drawer,getString(R.string.bottom_nav_title_2), Snackbar.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupDrawer(){
        navDrawer.setNavigationItemSelectedListener { menuItem ->
            drawer.closeDrawers()
            when(menuItem.itemId){
                R.id.drawer_home -> {
                    onBackPressed()
                    true
                }

                else -> false
            }

        }
    }

    private fun setupToolbar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }

    private fun backtoFirstActivity(){
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