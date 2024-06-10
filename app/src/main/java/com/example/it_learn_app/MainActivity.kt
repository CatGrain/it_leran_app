package com.example.it_learn_app

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.it_learn_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val TAG:String = "MainActivity"
    lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        //Initilize view
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Log.d(TAG, "Start Create Activity")
        Log.d(TAG, "Start Create Binding")
        val binding = ActivityMainBinding.inflate(layoutInflater)
        Log.d(TAG, "Binding created")
        Log.d(TAG, "Start set content view")
        setContentView(binding.root)
        Log.d(TAG, "Content view seted")

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                as NavHostFragment
        navController = navHost.navController

        val topAppBar = binding.topAppBar
        topAppBar.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "MenuItem selected: " + item.itemId)
        val handled = onNavDestinationSelected(item, navController)
        Log.d(TAG, "Navigation handled: $handled")
        return handled || super.onOptionsItemSelected(item)
    }
}
