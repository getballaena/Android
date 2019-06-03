package com.papered.gorae.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.papered.gorae.R
import com.papered.gorae.ui.main.coupon.CouponFragment
import com.papered.gorae.ui.main.map.MapFragment
import com.papered.gorae.ui.main.stamp.StampFragment
import com.papered.gorae.util.getToken
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_navigation.setupWithNavController(findNavController(R.id.main_container))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val fragment = main_container as NavHostFragment
        fragment.childFragmentManager.fragments[0].onActivityResult(requestCode, resultCode, data)
    }
}
