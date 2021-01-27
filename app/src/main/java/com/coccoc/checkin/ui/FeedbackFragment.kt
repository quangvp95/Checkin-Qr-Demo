package com.coccoc.checkin.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coccoc.checkin.R

class FeedbackFragment : Fragment() {

    companion object {
        fun newInstance() = FeedbackFragment()
    }

    private lateinit var viewModel: FeedbackViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feedback, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FeedbackViewModel::class.java)
        // TODO: Use the ViewModel
    }

}