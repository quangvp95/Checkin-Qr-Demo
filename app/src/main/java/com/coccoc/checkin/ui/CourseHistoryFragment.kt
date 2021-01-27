package com.coccoc.checkin.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.coccoc.checkin.R
import com.coccoc.checkin.adapter.CourseHistoryAdapter
import com.coccoc.checkin.base.BaseFragment
import com.coccoc.checkin.model.Course
import kotlinx.android.synthetic.main.fragment_course_history.*

class CourseHistoryFragment : BaseFragment() {

    companion object {
        fun newInstance() = CourseHistoryFragment()
    }

    private lateinit var viewModel: CourseHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_history, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CourseHistoryViewModel::class.java)
        // TODO: Use the ViewModel

        val courseList = listOf<Course>(
            Course("001", "ABC", "Day la lop A", listOf()),
            Course("002", "ABCD", "Day la lodgdf fA", listOf()),
            Course("003", "ABCE", "Day la lop df g", listOf()),
            Course("004", "ABCF", "Day la lopsd s", listOf())
        )

        rcvCourseHistory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rcvCourseHistory.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        rcvCourseHistory.adapter = CourseHistoryAdapter(courseList)
    }

}