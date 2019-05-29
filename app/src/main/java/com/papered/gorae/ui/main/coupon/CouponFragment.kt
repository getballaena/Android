package com.papered.gorae.ui.main.coupon

import android.app.Dialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import com.papered.gorae.R
import com.papered.gorae.adapter.CouponAdapter
import com.papered.gorae.connector.api
import com.papered.gorae.databinding.FragmentCouponBinding
import com.papered.gorae.util.DataBindingFragment
import kotlinx.android.synthetic.main.dialog_coupon.*
import kotlinx.android.synthetic.main.fragment_coupon.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponFragment : DataBindingFragment<FragmentCouponBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_coupon


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!).get(CouponViewModel::class.java)
        binding.vm = viewModel
        main_coupon_rv.adapter = CouponAdapter(viewModel)
        viewModel.getCoupon()

        viewModel.useCoupon.observe(this, Observer {
            val dialog = Dialog(activity!!)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_coupon)
            dialog.show()
            dialog.coupon_use_bt.setOnClickListener {
                api.deleteCoupon(
                    "hello",
                    hashMapOf(
                        "couponId" to viewModel.couponId.value,
                        "staffCode" to dialog.coupon_code_edit.text.toString()
                    )
                ).enqueue(object : Callback<Unit> {

                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.code() == 200) {
                            dialog.dismiss()
                            viewModel.getCoupon()
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {

                    }

                })
            }
        })
    }

}
