package com.papered.gorae.ui.main.coupon

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.papered.gorae.adapter.CouponAdapter
import com.papered.gorae.model.CouponModel

@BindingAdapter("couponData")
fun RecyclerView.setCouponData(data: LiveData<ArrayList<CouponModel>>) {
    val couponAdapter:CouponAdapter = adapter as CouponAdapter
    data.value?.let { couponAdapter.item = it }
}