package com.papered.gorae.ui.main.map

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.zxing.integration.android.IntentIntegrator
import com.papered.gorae.R
import com.papered.gorae.adapter.MapAdapter
import com.papered.gorae.connector.api
import com.papered.gorae.model.MapModel
import com.papered.gorae.model.QuizModel
import kotlinx.android.synthetic.main.fragment_map.*
import kotlinx.android.synthetic.main.include_code.*
import kotlinx.android.synthetic.main.include_notifiy.*
import kotlinx.coroutines.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MapFragment : androidx.fragment.app.Fragment() {

    val job = Job()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        code_btn.onClick {
            joinTeam()
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
                api.getQuiz(result.contents).enqueue(object : Callback<QuizModel> {
                    override fun onResponse(call: Call<QuizModel>, response: Response<QuizModel>) {
                        when(response.code()){
                            200 -> findNavController().navigate(MapFragmentDirections.actionMapFragmentToQuizFragment(response.body()!!))
                            204 -> toast("잘못 찍으셨는데요? ㅠㅠ")
                            205 -> toast("이미 같은 팀이 점령한 부스입니다.")
                        }
                    }

                    override fun onFailure(call: Call<QuizModel>, t: Throwable) {

                    }

                })
                toast(result.contents)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch(Dispatchers.IO + job) {
            while (true) {
                getMap()
                delay(5000)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        job.cancel()
    }

    fun getMap() {
        api.getMap().enqueue(object : Callback<MapModel> {
            override fun onResponse(call: Call<MapModel>, response: Response<MapModel>) {
                if (!job.isCancelled)
                    when (response.code()) {
                        200 -> {
                            code_group.visibility = View.VISIBLE
                            code_group.visibility = View.GONE
                            notify_group.visibility = View.GONE
                            val body = response.body()!!
                            map_myteam_tv.text = "나의 팀: ${body.myTeam}"
                            val sdf = SimpleDateFormat("hh:mm")
                            sdf.timeZone = TimeZone.getTimeZone("Asia/Seoul")
                            map_time.text = "종료 시간: ${sdf.format(Date(body.endTimestamp))}"
                            map_rv.layoutManager = LinearLayoutManager(context)
                            map_rv.adapter = MapAdapter(body.map)
                        }
                        403 -> {
                            code_group.visibility = View.GONE
                            code_group.visibility = View.VISIBLE
                            notify_group.visibility = View.GONE
                        }

                        406 -> {
                            code_group.visibility = View.GONE
                            code_group.visibility = View.GONE
                            notify_group.visibility = View.VISIBLE
                            notify_tv.text = "아직 게임이 시작되지 않았습니다.\n조금만 기다려주세요!"
                        }

                        408 -> {
                            code_group.visibility = View.GONE
                            code_group.visibility = View.GONE
                            notify_group.visibility = View.VISIBLE
                            notify_tv.text = "땅따먹기 시간이 만료되었습니다!\n메인 부스로 오셔서 결과를 확인해주세요!"
                        }
                    }
            }

            override fun onFailure(call: Call<MapModel>, t: Throwable) {
                toast("이거뜨겠지?")
            }

        })
    }

    fun joinTeam() {
        api.joinTeam(hashMapOf("joinCode" to code_et.text.toString())).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                when (response.code()) {
                    205, 403 -> toast("인증 코드가 잘못되었습니다.")
                    201 -> {
                        toast("인증 완료되었습니다.")
                        getMap()
                    }
                    204 -> toast("이미 팀에 참가되어있습니다. 게임이 시작될 때까지 기다려주세요!")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                toast("인터넷 상태를 확인해주세요.")
            }

        })
    }
}
