package com.papered.gorae.ui.main.coupon

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.papered.gorae.connector.api
import com.papered.gorae.model.CouponModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponViewModel(val app: Application) : AndroidViewModel(app) {
    val couponModel = MutableLiveData<ArrayList<CouponModel>>()

    fun getCoupon() {
        api.getCoupon("hello").enqueue(object : Callback<ArrayList<CouponModel>> {
            override fun onResponse(call: Call<ArrayList<CouponModel>>, response: Response<ArrayList<CouponModel>>) {
                couponModel.value = response.body()
            }

            override fun onFailure(call: Call<ArrayList<CouponModel>>, t: Throwable) {
            }

        })
    }
}
