package com.papered.gorae.ui.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.papered.gorae.R
import com.papered.gorae.connector.api
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_submit.onClick {
            api.auth(hashMapOf("name" to login_et_name.text))
        }
    }
}
