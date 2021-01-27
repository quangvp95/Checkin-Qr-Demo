package com.coccoc.checkin.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.coccoc.checkin.R
import com.coccoc.checkin.model.Course
import com.coccoc.checkin.ui.CourseHistoryFragmentDirections
import kotlinx.android.synthetic.main.item_course.view.*

class CourseHistoryAdapter(private val dataSet: List<Course>) : RecyclerView.Adapter<CourseHistoryAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var mCourse : Course

        init {
            view.setOnClickListener(this)
        }

        fun bind(course: Course) {
            mCourse = course
            view.txtCourseName.text = course.fileName
            view.txtCourseId.text = "Mã lớp: " + course.className
        }

        override fun onClick(v: View?) {
            view.findNavController().navigate(CourseHistoryFragmentDirections.actionCourseHistoryFragmentToLessonHistoryFragment())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size
}