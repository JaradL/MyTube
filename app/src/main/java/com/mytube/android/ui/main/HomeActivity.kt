package com.mytube.android.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.mytube.android.R
import com.mytube.android.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        setSupportActionBar(binding.toolbar)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment
        val navController = navHostFragment.navController
//        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_shorts,
                R.id.navigation_subscriptions,
                R.id.navigation_library
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val createFAB = binding.createFab
        createFAB.setOnClickListener {
            val modalCreateSheet = CreateBottomSheet()
            modalCreateSheet.show(supportFragmentManager, CreateBottomSheet.TAG)
        }
        supportActionBar?.title = "MyTube"
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
                val modalBottomSheet = SignInBottomSheet()
                modalBottomSheet.show(supportFragmentManager, SignInBottomSheet.TAG)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
