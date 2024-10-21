package com.example.sp22_bse_6a_demo.lecture.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.databinding.ActivityLecturesBinding
import com.example.sp22_bse_6a_demo.lecture.adopter.TimeTableAdopter
import com.example.sp22_bse_6a_demo.lecture.model.TimeTableModel
import com.example.sp22_bse_6a_demo.users.adopter.UserAdopter
import com.example.sp22_bse_6a_demo.users.model.Gender
import com.example.sp22_bse_6a_demo.users.model.User

class LecturesActivity : AppCompatActivity() {
    lateinit var binding: ActivityLecturesBinding
    val timeTableAdopter: TimeTableAdopter =
        TimeTableAdopter(TimeTableAdopter.diffCallBack)

    var lecturesList: List<TimeTableModel> = arrayListOf(
        TimeTableModel("Mon", 2),
        TimeTableModel("Tue", 3),
        TimeTableModel("Wed", 1),
        TimeTableModel("Thur", 0),
        TimeTableModel("Fri", 4)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@LecturesActivity, R.layout.activity_lectures)

        timeTableAdopter.submitList(lecturesList)
        binding.lecturesRV.adapter = timeTableAdopter
        binding.lecturesRV.layoutManager =
            LinearLayoutManager(this@LecturesActivity, RecyclerView.HORIZONTAL, false)

    }
}