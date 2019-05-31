package com.papered.gorae.connector

import com.papered.gorae.util.App
import com.papered.gorae.util.getToken
import okhttp3.Interceptor
import okhttp3.Response

class DeviceUuidInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
            .newBuilder()
            .addHeader("deviceuuid", getToken(App.getContext()!!))
            .build()

        return chain.proceed(originalRequest)

    }
}