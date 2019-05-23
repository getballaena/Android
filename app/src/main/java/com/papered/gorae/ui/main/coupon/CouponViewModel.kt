package com.papered.gorae.ui.main.coupon

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import com.papered.gorae.connector.api
import com.papered.gorae.model.CouponModel

class CouponViewModel(val app:Application) : AndroidViewModel(app) {
    val couponModel=MutableLiveData<ArrayList<CouponModel>>()
    
}
