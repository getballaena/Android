package com.papered.gorae.ui.main.coupon

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.papered.gorae.connector.api
import com.papered.gorae.model.CouponModel
import com.papered.gorae.util.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponViewModel(val app: Application) : AndroidViewModel(app) {

    val couponModel = MutableLiveData<ArrayList<CouponModel>>()
    val useCoupon = SingleLiveEvent<Any>()
    val couponId = MutableLiveData<String>()

    fun getCoupon() {
        api.getCoupon("hello").enqueue(object : Callback<ArrayList<CouponModel>> {
            override fun onResponse(call: Call<ArrayList<CouponModel>>, response: Response<ArrayList<CouponModel>>) {
                couponModel.value = response.body()
            }

            override fun onFailure(call: Call<ArrayList<CouponModel>>, t: Throwable) {
            }

        })
    }

    fun gotoCouponUse(index: Int) {
        couponId.value = couponModel.value!![index].couponId
        useCoupon.call()
    }
}
