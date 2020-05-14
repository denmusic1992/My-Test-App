package com.denischornyyapp.betrendy.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.denischornyyapp.betrendy.R
import com.denischornyyapp.betrendy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavController()
    }

    private fun setupNavController() {
        val navController = findNavController(R.id.nav_host_fragment_container)
        binding.bttmNav.setupWithNavController(navController)
        
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.loginFragment -> hideBottomNav()
                R.id.listEventsFragment -> showBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        binding.bttmNav.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        binding.bttmNav.visibility = View.GONE
    }
}
