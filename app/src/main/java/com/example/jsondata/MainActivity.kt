package com.example.jsondata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.jsondata.adapter.FragmentAdapter
import com.example.jsondata.fragments.UsersFragment
import com.example.jsondata.fragments.PhotosFragment
import com.example.jsondata.fragments.PostsFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    //    private lateinit var tableLayout: TableLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var tabLayout: TabLayout = findViewById(R.id.tabLayout)

        val viewPager2: ViewPager2 = findViewById(R.id.viewPager2)

        val arrayList: ArrayList<Fragment> = ArrayList()
        arrayList.add(PhotosFragment())
        arrayList.add(PostsFragment())
        arrayList.add(UsersFragment())

        val fragmentAdapter = FragmentAdapter(arrayList, supportFragmentManager, lifecycle)
        tabLayout.addTab(tabLayout.newTab().setText("Photos"))
        tabLayout.addTab(tabLayout.newTab().setText("Posts"))
        tabLayout.addTab(tabLayout.newTab().setText("comments"))
        viewPager2.adapter = fragmentAdapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))

            }
        })


    }
}