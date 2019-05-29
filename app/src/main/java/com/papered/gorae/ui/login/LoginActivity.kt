package com.papered.gorae.ui.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.papered.gorae.R
import com.papered.gorae.connector.api
import com.papered.gorae.util.getToken
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_submit.onClick {
            api.auth(getToken(baseContext), hashMapOf("name" to login_et_name.text.toString()))
                .enqueue(object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        when (response.code()) {
                            201 -> toast("성공 ㅎㅎ")
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
