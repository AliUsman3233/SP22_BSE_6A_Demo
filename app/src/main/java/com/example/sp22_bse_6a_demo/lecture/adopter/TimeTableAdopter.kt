package com.example.sp22_bse_6a_demo.lecture.adopter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.databinding.DaysViewBinding
import com.example.sp22_bse_6a_demo.databinding.FemaleUserRowBinding
import com.example.sp22_bse_6a_demo.databinding.MaleUserRowBinding
import com.example.sp22_bse_6a_demo.lecture.model.TimeTableModel
import com.example.sp22_bse_6a_demo.users.model.Gender
import com.example.sp22_bse_6a_demo.users.model.User

class TimeTableAdopter(
    diffCallback: DiffUtil.ItemCallback<TimeTableModel>
) :
    ListAdapter<TimeTableModel, TimeTableAdopter.TimeTableUserViewHolder>(diffCallback) {
    private val tag = this@TimeTableAdopter.javaClass.name

    class TimeTableUserViewHolder(var binding: DaysViewBinding, var ctx: Context) :
        RecyclerView.ViewHolder(binding.root) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeTableUserViewHolder {
        val binding =
            DaysViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TimeTableUserViewHolder(binding = binding, ctx = parent.context)
    }

    override fun onBindViewHolder(holder: TimeTableUserViewHolder, position: Int) {
        val dataItem = getItem(position)
        holder.binding.timetableModel = dataItem

        val daysCircleList: List<View> = arrayListOf(
            holder.binding.lecture1View,
            holder.binding.lecture2View,
            holder.binding.lecture3View,
            holder.binding.lecture4View,
        )


        for (i in 0..(dataItem.numberOfLectures?:0)-1) {
            daysCircleList[i].visibility = View.VISIBLE
        }

    }


    object diffCallBack : DiffUtil.ItemCallback<TimeTableModel>() {
        override fun areItemsTheSame(oldItem: TimeTableModel, newItem: TimeTableModel): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: TimeTableModel, newItem: TimeTableModel): Boolean {
            return false
        }

    }
}
