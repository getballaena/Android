package com.papered.gorae.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.papered.gorae.R
import com.papered.gorae.connector.api
import com.papered.gorae.ui.MainActivity
import com.papered.gorae.util.getToken
import com.papered.gorae.util.key
import com.papered.gorae.util.saveToken
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (getToken(baseContext) == "") {
            saveToken(baseContext, UUID.randomUUID().toString())
        }

        login_submit.onClick {
            api.auth(getToken(baseContext)!!, hashMapOf("name" to login_et_name.text.toString()))
                .enqueue(object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        when (response.code()) {
                            201 -> {
                                toast("로그인에 성공하였습니다.")
                                startActivity<MainActivity>()
                            }
                            else -> toast("문제가 발생했습니다.")
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        toast("인터넷 연결 상태를 확인해주세요.")
                    }

                })
        }
    }
}
