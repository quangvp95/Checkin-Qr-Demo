package com.coccoc.checkin.model

import com.google.gson.annotations.SerializedName

data class Course(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_name") val fileName: String,
    @SerializedName("class_name") val className: String,
    @SerializedName("items") val lessonList: List<Lesson>
)
