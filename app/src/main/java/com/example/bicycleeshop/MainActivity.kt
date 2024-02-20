package com.example.bicycleeshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.example.bicycleeshop.Fragments.CartFragment
import com.example.bicycleeshop.Fragments.CategoryFragment
import com.example.bicycleeshop.Fragments.HomeFragment
import com.example.bicycleeshop.databinding.ActivityMainBinding
import com.google.android.material.bottomappbar.BottomAppBar

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomnav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.cart -> replaceFragment(CartFragment())
                R.id.category -> replaceFragment(CategoryFragment())
                else -> {false  }
            }

        }

    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
        return true
    }

}