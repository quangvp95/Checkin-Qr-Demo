package com.coccoc.checkin.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coccoc.checkin.R
import com.coccoc.checkin.model.Lesson
import kotlinx.android.synthetic.main.item_lesson.view.*

class LessonHistoryAdapter(private val dataSet: List<Lesson>) : RecyclerView.Adapter<LessonHistoryAdapter.ViewHolder>() {
    
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var mLesson : Lesson

        init {
            view.setOnClickListener(this)
        }

        fun bind(lesson: Lesson) {
            mLesson = lesson
            view.txtLessonId.text = "Tiết học " + lesson.id
            view.txtLessonTime.text = lesson.time
            view.txtLessonStatus.text = lesson.status
        }

        override fun onClick(v: View?) {
            Log.d("henzy", "click Lesson " + mLesson.id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size
}