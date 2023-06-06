package com.remedios.activity5.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.remedios.activity5.Fragments.FragmentSearch
import com.remedios.activity5.Fragments.FragmentTransaction
import com.remedios.activity5.Fragments.FragmentList


internal class MyAdapter(var context: Context, fm:FragmentManager, var totalTabs:Int): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> { FragmentList()   }
            1 -> { FragmentSearch() }
            2 -> { FragmentTransaction()    }
            else -> {getItem(position)}
        }
    }


    override fun getCount(): Int {
        return totalTabs
    }
}