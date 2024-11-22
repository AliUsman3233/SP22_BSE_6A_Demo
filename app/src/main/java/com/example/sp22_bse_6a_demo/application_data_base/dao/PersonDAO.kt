package com.example.sp22_bse_6a_demo.application_data_base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sp22_bse_6a_demo.application_data_base.entities.PersonEntity

@Dao
interface PersonDao {
    @Query("SELECT * FROM person_entity")
    fun getAll(): List<PersonEntity>

    @Query("SELECT * FROM person_entity WHERE name LIKE :first LIMIT 1") //AND "last_name LIKE :last
    fun findByName(first: String): PersonEntity

    @Insert
    fun insertAll(users: PersonEntity)

    //    @Query("SELECT * FROM person_entity WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<User>

//    @Delete
//    fun delete(user: User)
}