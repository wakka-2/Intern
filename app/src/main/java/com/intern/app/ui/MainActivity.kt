package com.intern.app.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.intern.app.R
import com.intern.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private val listener = NavController.OnDestinationChangedListener { _, _, _ ->
        hideAllFragments()
    }
    val positionList=ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
        setupActionBar()
    }

    private fun setupActionBar() {
        val actionBar = supportActionBar

        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_menu_24)
    }

    private fun setupNavigation() {
        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.mainActivityHostFragment)

        bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener(listener)

        val actionBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.cartFragment, R.id.bookmarkFragment, R.id.profileFragment
            )
        )

        setupActionBarWithNavController(navController,actionBarConfiguration)
        NavigationUI.setupWithNavController(toolbar, navController, null)

    }
    fun hideNavigation(){
        bottomNavigation.visibility = View.GONE
    }
    fun showNavigation(){
        bottomNavigation.visibility = View.VISIBLE
    }
}