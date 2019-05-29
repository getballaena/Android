package com.papered.gorae.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.papered.gorae.R
import com.papered.gorae.ui.main.coupon.CouponFragment
import com.papered.gorae.ui.main.map.MapFragment
import com.papered.gorae.ui.main.stamp.StampFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_navigation.setupWithNavController(findNavController(R.id.main_container))
    }
}
