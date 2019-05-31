package com.papered.gorae.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.papered.gorae.ui.login.LoginActivity
import com.papered.gorae.util.getToken
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("이시ㅡ발", "왜안되지 ${getToken(baseContext)}")
        if (getToken(baseContext) == "" || getToken(baseContext) == null)
            startActivity<LoginActivity>()
        else
            startActivity(Intent(this, MainActivity::class.java))
        finish();
    }
}