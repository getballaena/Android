package com.papered.gorae.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.papered.gorae.ui.login.LoginActivity
import com.papered.gorae.util.getToken
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getToken(baseContext) == "")
            startActivity<LoginActivity>()
        else
            startActivity(Intent(this, MainActivity::class.java))
        finish();
    }
}