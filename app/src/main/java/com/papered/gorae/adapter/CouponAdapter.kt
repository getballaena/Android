package com.papered.gorae.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.papered.gorae.databinding.ItemCouponBinding
import com.papered.gorae.model.CouponModel
import com.papered.gorae.ui.main.coupon.CouponViewModel


class CouponAdapter(val viewModel: CouponViewModel) : RecyclerView.Adapter<CouponAdapter.ViewHolder>() {

    var item = arrayListOf<CouponModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding = ItemCouponBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        viewHolder.bind()
    }

    inner class ViewHolder(val binding: ItemCouponBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.couponModel = item[adapterPosition]
            binding.index = adapterPosition
            binding.vm = viewModel
        }
    }
}
