package com.coccoc.checkin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.coccoc.checkin.MainActivity
import com.coccoc.checkin.R
import com.coccoc.checkin.base.BaseFragment
import org.json.JSONObject

class ScanFragment : BaseFragment(), View.OnClickListener {

    companion object {
        const val CHECKIN_SESSION_CODE = "checkin_session_code"
        const val FILE_ID = "file_id"
        const val LESSION_NAME = "file_name"
        const val CLASS_NAME = "class_name"
        const val SESSION_NAME = "session_name"
        const val CHECKIN_START_TIME = "checkin_start_time"
        const val CHECKIN_END_TIME = "checkin_end_time"
        const val CHECKIN_SESSION_STATUS = "checkin_session_status"

        fun newInstance(info: String): ScanFragment {
            val fragment = ScanFragment()
            val extra = Bundle()
            extra.putString(MainActivity.RESULT_QR, info)
            fragment.arguments = extra
            return fragment
        }
    }

    private lateinit var viewModel: ScanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_scan, container, false)
        val json = JSONObject(arguments!!.get(MainActivity.RESULT_QR) as String)
        v.findViewById<TextView>(R.id.txt_lesson_title).text = json.get(LESSION_NAME).toString()
        v.findViewById<TextView>(R.id.txt_grade_info).text = json.get(CLASS_NAME).toString()
        v.findViewById<TextView>(R.id.txt_lesson_number).text = json.get(SESSION_NAME).toString()
        v.findViewById<Button>(R.id.bt_lesson_confirm).setOnClickListener(this)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScanViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.bt_lesson_confirm) {

        }
    }

}