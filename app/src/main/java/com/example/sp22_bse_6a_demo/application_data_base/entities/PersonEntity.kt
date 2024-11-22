package com.example.sp22_bse_6a_demo.application_data_base.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity("person_entity")
data class PersonEntity(
    @ColumnInfo(name = "name") var name: String? = "",
    @ColumnInfo(name = "email") var email: String? = "",
    @ColumnInfo(name = "age") var age: String? = "",
    @ColumnInfo(name = "address") var address: String? = "",
)
