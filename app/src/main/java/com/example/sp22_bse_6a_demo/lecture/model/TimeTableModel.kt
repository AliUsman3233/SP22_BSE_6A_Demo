package com.example.sp22_bse_6a_demo.lecture.model

data class TimeTableModel(
    val day:String? = "",
    val numberOfLectures: Int? = 0,
) {
    fun getNumberOfLecturesAsString():String {
        return numberOfLectures.toString()
    }
}
