package com.coccoc.checkin.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.coccoc.checkin.MainActivity
import com.coccoc.checkin.R
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_student_id.view.*

class StudentIdFragment : Fragment() {

    companion object {
        fun newInstance() = StudentIdFragment()
    }

    private lateinit var viewModel: StudentIdViewModel
    private lateinit var mTextId: TextInputLayout
    private lateinit var mButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_student_id, container, false)
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)!!

        mButton = v.bt_student_id_next
        mTextId = v.edt_student_id

        mButton.setOnClickListener(View.OnClickListener { _ ->
            with(sharedPref.edit()) {
                putString(getString(R.string.student_id_key), mTextId.editText?.text.toString())
                apply()
            }

            findNavController().navigate(StudentIdFragmentDirections.actionStudentIdFragmentToStudentNameFragment())
        })

        mTextId.editText?.addTextChangedListener(afterTextChanged = {
            mButton.isEnabled = !it.isNullOrEmpty()
        })
        mTextId.editText?.setText(sharedPref.getString(getString(R.string.student_id_key), ""))

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StudentIdViewModel::class.java)
        // TODO: Use the ViewModel
    }

}