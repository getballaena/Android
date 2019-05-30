package com.papered.gorae.ui.main.map


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.papered.gorae.R
import kotlinx.android.synthetic.main.fragment_result.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ResultFragment : Fragment() {

    val boothName by lazy { ResultFragmentArgs.fromBundle(arguments!!).boothName }
    val isCorrect by lazy { ResultFragmentArgs.fromBundle(arguments!!).isCorrect }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result_booth.text = boothName
        result_result.text = when (isCorrect) {
            true -> "O"
            else -> "X"
        }
        result_btn.onClick {
            findNavController().navigate(ResultFragmentDirections.actionResultFragmentToMapFragment())
        }
    }

}
