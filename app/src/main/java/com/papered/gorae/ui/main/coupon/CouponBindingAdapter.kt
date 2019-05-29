package com.papered.gorae.ui.main.coupon

import androidx.lifecycle.LiveData
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.papered.gorae.adapter.CouponAdapter
import com.papered.gorae.model.CouponModel

@BindingAdapter("couponData")
fun androidx.recyclerview.widget.RecyclerView.setCouponData(data: LiveData<ArrayList<CouponModel>>) {
    val couponAdapter:CouponAdapter = adapter as CouponAdapter
    data.value?.let { couponAdapter.item = it }
}