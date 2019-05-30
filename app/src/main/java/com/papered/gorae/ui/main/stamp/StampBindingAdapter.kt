package com.papered.gorae.ui.main.stamp

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.papered.gorae.adapter.CouponAdapter
import com.papered.gorae.adapter.StampAdapter
import com.papered.gorae.model.CouponModel
import com.papered.gorae.model.StampModel

@BindingAdapter("stampData")
fun androidx.recyclerview.widget.RecyclerView.setStampData(data: LiveData<ArrayList<StampModel>>) {
    val stampAdapter: StampAdapter = adapter as StampAdapter
    data.value?.let { stampAdapter.item = it }
}