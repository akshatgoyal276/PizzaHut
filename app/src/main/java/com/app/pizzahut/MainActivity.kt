package com.app.pizzahut

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.app.pizzahut.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var activity: MainActivity
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity = this

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainFragment,
                R.id.favoriteFragment,
                R.id.ordersFragment,
                R.id.moreFragment
            )
        )
        setupActionBarWithNavController(getNavController(), appBarConfiguration)
        binding.appBarMain.bottomNavView.apply {
            setupWithNavController(getNavController())
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.bottom_nav_home -> {
                        getNavController().navigate(R.id.mainFragment)
                        true
                    }
                    R.id.bottom_nav_fav -> {
                        getNavController().navigate(R.id.favoriteFragment)
                        true
                    }
                    R.id.bottom_nav_orders -> {
                        getNavController().navigate(R.id.ordersFragment)
                        true
                    }
                    R.id.bottom_nav_more -> {
                        getNavController().navigate(R.id.moreFragment)
                        true
                    }

                    else -> false
                }
            }
        }
        binding.navView.setupWithNavController(getNavController())
    }

    override fun onResume() {
        activity = this
        super.onResume()
    }

    private fun getNavController(): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        return navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostFragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}