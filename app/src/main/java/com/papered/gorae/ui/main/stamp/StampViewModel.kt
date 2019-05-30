package com.papered.gorae.ui.main.stamp

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.papered.gorae.connector.api
import com.papered.gorae.model.StampModel
import com.papered.gorae.util.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StampViewModel(val app: Application) : AndroidViewModel(app) {

    val stampModel = MutableLiveData<ArrayList<StampModel>>()
    val gotoQuestion = SingleLiveEvent<Any>()
    val stampName = MutableLiveData<String>()
    val gotoShoot = SingleLiveEvent<Any>()


    fun getStamp() {
        api.getStamp("hello").enqueue(object : Callback<ArrayList<StampModel>> {

            override fun onResponse(call: Call<ArrayList<StampModel>>, response: Response<ArrayList<StampModel>>) {
                stampModel.value = response.body()
            }

            override fun onFailure(call: Call<ArrayList<StampModel>>, t: Throwable) {

            }

        })
    }

    fun gotoQuestion() {
        gotoQuestion.call()
    }

    fun gotoShoot() {
        gotoShoot.call()
    }

    fun postStamp() {
        api.postStamp("hello", hashMapOf("stampName" to stampName.value)).enqueue(object : Callback<Unit> {

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                when (response.code()) {
                    200 -> Toast.makeText(app.baseContext, "인식이 성공하였습니다!", Toast.LENGTH_SHORT).show()
                    204 -> Toast.makeText(app.baseContext, "존재하지 않는 스탬프입니다.", Toast.LENGTH_SHORT).show()
                    205 -> Toast.makeText(app.baseContext, "이미 촬영한 스탬프 입니다.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
            }
        })
    }
}
