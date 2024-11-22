package com.example.sp22_bse_6a_demo.application_data_base.roomDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sp22_bse_6a_demo.application_data_base.dao.PersonDao
import com.example.sp22_bse_6a_demo.application_data_base.entities.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class Sp22Database : RoomDatabase() {
    abstract fun personDao(): PersonDao
}