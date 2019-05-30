package com.papered.gorae.ui.main.stamp

import android.app.Dialog
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.lifecycle.Observer
import com.google.zxing.integration.android.IntentIntegrator

import com.papered.gorae.R
import com.papered.gorae.adapter.CouponAdapter
import com.papered.gorae.adapter.StampAdapter
import com.papered.gorae.connector.api
import com.papered.gorae.databinding.FragmentStampBinding
import com.papered.gorae.ui.main.coupon.CouponViewModel
import com.papered.gorae.util.DataBindingFragment
import kotlinx.android.synthetic.main.dialog_coupon.*
import kotlinx.android.synthetic.main.fragment_coupon.*
import kotlinx.android.synthetic.main.fragment_stamp.*
import org.jetbrains.anko.support.v4.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StampFragment : DataBindingFragment<FragmentStampBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_stamp

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!).get(StampViewModel::class.java)
        binding.vm = viewModel
        viewModel.getStamp()
        stamp_list_rv.adapter = StampAdapter(viewModel)
        viewModel.gotoQuestion.observe(this, Observer {
            val dialog = Dialog(activity!!)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_stamp_info)
            dialog.show()
        })
        viewModel.gotoShoot.observe(this, Observer {
            IntentIntegrator(activity).initiateScan()
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val viewModel = ViewModelProviders.of(activity!!).get(StampViewModel::class.java)
        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result == null) {

            } else {
                viewModel.stampName.value = result.contents
                viewModel.postStamp()
                viewModel.getStamp()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
