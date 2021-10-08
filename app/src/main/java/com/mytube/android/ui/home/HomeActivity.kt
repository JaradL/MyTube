package com.mytube.android.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.mytube.android.R
import com.mytube.android.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_stories,
                R.id.navigation_create,
                R.id.navigation_subscriptions,
                R.id.navigation_library
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        title = "MyTube"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_cast -> {
                Snackbar.make(findViewById(android.R.id.content), "Cast", Snackbar.LENGTH_SHORT)
                    .show()
                true
            }
            R.id.action_notifications -> {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Notifications",
                    Snackbar.LENGTH_SHORT
                ).show()
                true
            }
            R.id.action_search -> {
                Snackbar.make(findViewById(android.R.id.content), "Search", Snackbar.LENGTH_SHORT)
                    .show()
                true
            }
            R.id.action_account -> {
                Snackbar.make(findViewById(android.R.id.content), "Account", Snackbar.LENGTH_SHORT)
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}