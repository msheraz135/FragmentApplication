package com.example.fragmentapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragmentapplication.Fragments.HomeFragment
import com.example.fragmentapplication.Fragments.NotificationFragment
import com.example.fragmentapplication.Fragments.SearchFragment

private const val NUM_FRAGMENTS =3
class FragmentAdapter(fragment:FragmentManager,lifecycle:Lifecycle)
    :FragmentStateAdapter(fragment, lifecycle) {
    override fun getItemCount(): Int {
        return NUM_FRAGMENTS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return HomeFragment()
            1 -> return NotificationFragment()
        }
        return SearchFragment()

    }
}