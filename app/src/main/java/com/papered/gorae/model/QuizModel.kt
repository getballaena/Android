package com.papered.gorae.model

import java.io.Serializable

data class QuizModel(
    val boothName: String,
    val choices: ArrayList<String>,
    val content: String,
    val problemId: String
) : Serializable

