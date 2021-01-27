package com.coccoc.checkin.model

import com.google.gson.annotations.SerializedName

data class HistoryResponse(@SerializedName("history") val history: List<Course>)