package com.coccoc.checkin.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class QrResult : Serializable {
    @SerializedName("checkin_session_code")
    var checkinSessionCode: String? = ""

    @SerializedName("file_id")
    var fileId: String? = ""

    @SerializedName("file_name")
    var lessonName: String? = ""

    @SerializedName("class_name")
    var className: String? = ""

    @SerializedName("session_name")
    var sessionName: String? = ""

    @SerializedName("checkin_start_time")
    var checkinStartTime: String? = ""

    @SerializedName("checkin_end_time")
    var checkinEndTime: String? = ""

    @SerializedName("checkin_session_status")
    var checkinSessionStatus: String? = ""

    @SerializedName("learner_id")
    var learnerId: String? = ""

    @SerializedName("learner_first_name")
    var learnerFirstName: String? = ""

    @SerializedName("learner_last_name")
    var learnerLastName: String? = ""
}