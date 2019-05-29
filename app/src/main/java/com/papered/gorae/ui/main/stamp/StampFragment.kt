package com.papered.gorae.ui.main.stamp

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.papered.gorae.R

class StampFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = StampFragment()
    }

    private lateinit var viewModel: StampViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stamp, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StampViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
