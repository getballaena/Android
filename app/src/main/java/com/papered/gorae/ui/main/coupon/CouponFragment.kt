package com.papered.gorae.ui.main.coupon

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.papered.gorae.R
import com.papered.gorae.adapter.CouponAdapter
import com.papered.gorae.databinding.FragmentCouponBinding
import com.papered.gorae.util.DataBindingFragment
import kotlinx.android.synthetic.main.fragment_coupon.*
import org.jetbrains.anko.startActivity

class CouponFragment : DataBindingFragment<FragmentCouponBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_coupon

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!).get(CouponViewModel::class.java)
        binding.vm = viewModel
        main_coupon_rv.adapter = CouponAdapter(viewModel)
        viewModel.getCoupon()
    }

}
