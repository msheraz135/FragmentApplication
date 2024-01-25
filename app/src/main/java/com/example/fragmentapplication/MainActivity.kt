package com.example.fragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.example.fragmentapplication.Fragments.HomeFragment
import com.example.fragmentapplication.Fragments.NotificationFragment
import com.example.fragmentapplication.Fragments.SearchFragment
import com.example.fragmentapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout.LabelVisibility

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var btmnavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btmnavigation= binding.navView
//        btmnavigation.labelVisibilityMode =BottomNavigationView.LABEL_VISIBILITY_LABELED

        val fragmentContainer = binding.navHostFragment
        btmnavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_nav -> {
                    switchFragment(fragmentContainer , HomeFragment())
                    true
                }
                R.id.notification_nav -> {
                    switchFragment(fragmentContainer , NotificationFragment())
                    true
                }
                R.id.search_nav -> {
                    switchFragment(fragmentContainer, SearchFragment())
                    true
                }
            }
            false
        }
        switchFragment(fragmentContainer, HomeFragment())
    }
    fun switchFragment(container: ViewGroup   ,fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(container.id, fragment).commit()
    }
}