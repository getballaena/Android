package com.papered.gorae.ui.main.coupon

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.papered.gorae.R

class CouponFragment : Fragment() {

    companion object {
        fun newInstance() = CouponFragment()
    }

    private lateinit var viewModel: CouponViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.coupon_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
