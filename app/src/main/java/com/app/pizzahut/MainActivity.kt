package com.app.pizzahut

import android.os.Bundle
import androidx.navigation.ui.setupWithNavController
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.app.pizzahut.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var activity : MainActivity
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ),  binding.drawerLayout
        )
        setupActionBarWithNavController(getNavController(), appBarConfiguration)
        binding.navView.setupWithNavController(getNavController())
    }

    private fun getNavController(): NavController {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        return navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostFragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}