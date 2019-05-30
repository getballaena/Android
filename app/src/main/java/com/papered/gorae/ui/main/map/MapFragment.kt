package com.papered.gorae.ui.main.map

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.gson.JsonObject
import com.google.zxing.integration.android.IntentIntegrator
import com.papered.gorae.R
import com.papered.gorae.connector.api
import kotlinx.android.synthetic.main.fragment_map.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapFragment : androidx.fragment.app.Fragment() {

    private lateinit var viewModel: MapViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        api.checkTeam().enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                when (response.code()) {
                    200 -> {
                        map_group.visibility = View.VISIBLE
                        code_group.visibility = View.GONE

                        val myTeam = response.body()!!["team"].asString
                        map_myteam_tv.text = myTeam
                    }
                    else -> {
                        map_group.visibility = View.GONE
                        code_group.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                toast("인터넷 상태를 확인해주세요.")
            }

        })

        code_btn.onClick {
            api.joinTeam(hashMapOf("joinCode" to code_tv.text.toString())).enqueue(object : Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    toast("인터넷 상태를 확인해주세요.")
                }

            })
        }

        map_fab.onClick {
            IntentIntegrator(activity).initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result == null) {

            } else {

                toast(result.contents)
            }
        } else {
            toast("Else")
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
