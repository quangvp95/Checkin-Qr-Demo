package com.coccoc.checkin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.coccoc.checkin.R

class CheckInResultFragment : Fragment() {

    companion object {
        fun newInstance() = CheckInResultFragment()
    }

    private lateinit var viewModel: CheckInResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_check_in_result, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CheckInResultViewModel::class.java)
        // TODO: Use the ViewModel
    }

}