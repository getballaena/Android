package com.papered.gorae.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.papered.gorae.R
import com.papered.gorae.ui.main.coupon.CouponFragment
import com.papered.gorae.ui.main.map.MapFragment
import com.papered.gorae.ui.main.stamp.StampFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navigation_map -> {
                transaction.replace(R.id.main_container, MapFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_stamp -> {
                transaction.replace(R.id.main_container, StampFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_coupon -> {
                transaction.replace(R.id.main_container, CouponFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().run {
            replace(R.id.main_container, MapFragment())
            commit()
        }
        main_navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
    }
}
