package com.example.fragmentapplication

import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmentapplication.databinding.ActivityMainViewPagerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivityViewPager : AppCompatActivity() {
    val array = arrayOf("Home", "Notification","Search")

    private lateinit var binding: ActivityMainViewPagerBinding

    private lateinit var btmNav: BottomNavigationView
    private lateinit var tabLayout: TabLayout
    private lateinit var viewpager2: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
            btmNav = binding.navView2
            tabLayout= binding.tabLayout
        viewpager2= binding.viewPager


        val adapter =FragmentAdapter(supportFragmentManager, lifecycle)
        viewpager2.adapter= adapter

        TabLayoutMediator(tabLayout, viewpager2) { tab, position ->
            tab.text = array[position]
        }.attach()

        viewpager2.registerOnPageChangeCallback( object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                btmNav.menu.getItem(position).isChecked=true
            }
        })
        btmNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_nav -> {
                    viewpager2.currentItem = 0
                    true
                }
                R.id.notification_nav -> {
                    viewpager2.currentItem = 1
                    true
                }
                R.id.search_nav -> {
                    viewpager2.currentItem = 2
                    true
                }
            }
            false
        }


    }

}