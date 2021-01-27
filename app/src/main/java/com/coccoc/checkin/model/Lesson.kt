package com.coccoc.checkin.model

import com.google.gson.annotations.SerializedName

data class Lesson(
    @SerializedName("session_name") val id: String,
    @SerializedName("history_created_time") val time: String,
    @SerializedName("checkin_learner_status") val status: String
)
