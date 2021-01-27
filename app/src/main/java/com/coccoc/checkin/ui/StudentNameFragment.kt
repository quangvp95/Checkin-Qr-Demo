package com.coccoc.checkin.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.coccoc.checkin.MainActivity
import com.coccoc.checkin.QrActivity
import com.coccoc.checkin.R
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_student_name.view.*

class StudentNameFragment : Fragment() {

    companion object {
        fun newInstance() = StudentNameFragment()
    }

    private lateinit var viewModel: StudentNameViewModel
    private lateinit var mTextLastName: TextInputLayout
    private lateinit var mTextFirstName: TextInputLayout
    private lateinit var mButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_student_name, container, false)
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)!!

        mButton = v.bt_student_name_confirm
        mTextLastName = v.edt_student_last_name
        mTextFirstName = v.edt_student_first_name

        mButton.setOnClickListener { _ ->
            with(sharedPref.edit()) {
                putString(
                    getString(R.string.student_first_name_key),
                    mTextFirstName.editText?.text.toString()
                )
                putString(getString(R.string.student_last_name_key), mTextLastName.editText?.text.toString())
                apply()
            }

            startActivityForResult(Intent(context, QrActivity::class.java), MainActivity.QR_REQUEST)
        }

        mTextLastName.editText?.addTextChangedListener(afterTextChanged = {
            mButton.isEnabled = !mTextLastName.editText?.text.isNullOrEmpty() && !mTextFirstName.editText?.text.isNullOrEmpty()
        })
        mTextLastName.editText?.setText(sharedPref.getString(getString(R.string.student_last_name_key),""))

        mTextFirstName.editText?.addTextChangedListener(afterTextChanged = {
            mButton.isEnabled = !mTextLastName.editText?.text.isNullOrEmpty() && !mTextFirstName.editText?.text.isNullOrEmpty()
        })
        mTextFirstName.editText?.setText(sharedPref.getString(getString(R.string.student_first_name_key),""))

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StudentNameViewModel::class.java)
        // TODO: Use the ViewModel
    }

}