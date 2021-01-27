package com.coccoc.checkin.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.coccoc.checkin.R
import com.coccoc.checkin.adapter.LessonHistoryAdapter
import com.coccoc.checkin.model.Lesson
import kotlinx.android.synthetic.main.fragment_lesson_history.*

class LessonHistoryFragment : Fragment() {

    companion object {
        fun newInstance() = LessonHistoryFragment()
    }

    private lateinit var viewModel: LessonHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lesson_history, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LessonHistoryViewModel::class.java)
        // TODO: Use the ViewModel

        val lessonList = listOf<Lesson>(
            Lesson("001", "23:10:10", "true"),
            Lesson("002", "23:13:10", "true"),
            Lesson("003", "23:13:10", "true"),
            Lesson("004", "23:11:13", "true"),
            Lesson("005", "23:16:17", "true")
        )

        rcvLessonHistory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rcvLessonHistory.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        rcvLessonHistory.adapter = LessonHistoryAdapter(lessonList)
    }

}