package com.coccoc.checkin.ui

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.coccoc.checkin.MainActivity
import com.coccoc.checkin.QrActivity
import com.coccoc.checkin.R
import com.coccoc.checkin.base.BaseFragment
import com.coccoc.checkin.model.QrResult
import com.coccoc.checkin.network.ApiService
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_scan.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScanFragment : BaseFragment(), View.OnClickListener {

    companion object {
        fun newInstance(info: String): ScanFragment {
            val fragment = ScanFragment()
            val extra = Bundle()
            extra.putString(MainActivity.RESULT_QR, info)
            fragment.arguments = extra
            return fragment
        }
    }

    private lateinit var viewModel: ScanViewModel
    private lateinit var lessonInfo: QrResult
    private lateinit var api: ApiService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_scan, container, false)

        lessonInfo =
            Gson().fromJson(arguments!!.get(MainActivity.RESULT_QR) as String, QrResult::class.java)
        v.txt_lesson_title.text = lessonInfo.lessonName
        v.txt_grade_info.text = lessonInfo.className
        v.txt_lesson_number.text = lessonInfo.sessionName
        v.bt_lesson_confirm.setOnClickListener(this)

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)!!
        lessonInfo.learnerId = sharedPref.getString(getString(R.string.student_id_key), "")
        lessonInfo.learnerFirstName =
            sharedPref.getString(getString(R.string.student_first_name_key), "")
        lessonInfo.learnerLastName =
            sharedPref.getString(getString(R.string.student_last_name_key), "")


        api = ApiService.create()
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScanViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.bt_lesson_confirm) {
            api.checkin(lessonInfo).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.code() == 200) {
                        showDialog(true)
                    } else {
                        showDialog(false)
                    }
                }
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    showDialog(false)
                }
            })
        }
    }

    fun showDialog(success : Boolean) {
        AlertDialog.Builder(requireContext())
            .setTitle(if (success) R.string.checkin_success_dialog_title else R.string.checkin_fail_dialog_title)
            .setMessage(if (success) R.string.checkin_success_dialog_content else R.string.checkin_fail_dialog_content)
            .setPositiveButton(if (success) R.string.checkin_success_dialog_button else R.string.checkin_fail_dialog_button,
                DialogInterface.OnClickListener { dialog, which ->
                    run {
                        if (success) {
                            (activity as MainActivity).openFragment(CourseHistoryFragment.newInstance())
                        } else {
                            startActivityForResult(Intent(context, QrActivity::class.java), MainActivity.QR_REQUEST)
                        }
                    }
                })
    }

}