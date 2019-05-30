package com.papered.gorae.ui.main.map


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.papered.gorae.R
import com.papered.gorae.connector.api
import kotlinx.android.synthetic.main.fragment_quiz.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuizFragment : Fragment() {

    val args by lazy {
        QuizFragmentArgs.fromBundle(arguments!!).quiz
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quiz_btn_1.onClick { solve(quiz_btn_1.text.toString()) }
        quiz_btn_2.onClick { solve(quiz_btn_2.text.toString()) }
        quiz_btn_3.onClick { solve(quiz_btn_3.text.toString()) }
        quiz_btn_4.onClick { solve(quiz_btn_4.text.toString()) }
    }

    fun solve(answer: String) {
        api.solveQuiz(
            args.boothName,
            hashMapOf(
                "problemId" to args.problemId,
                "answer" to answer
            )
        ).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                when (response.code()) {
                    201 -> toast("정답입니다!")
                    205 -> toast("오답입니다!")
                    409 -> toast("앗! 다른 팀이 점령했군요 ㅠㅠ")
                }
                findNavController().popBackStack()
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                toast("인터넷 상태를 확인해주세요")
            }

        })
//        api.solveQuiz(args.boothName)
    }
}
