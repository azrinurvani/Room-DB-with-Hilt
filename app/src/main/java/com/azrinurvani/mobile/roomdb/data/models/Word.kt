package com.azrinurvani.mobile.roomdb.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "word_table", indices = [Index(value = ["word"], unique = true)])
data class Word(

    @PrimaryKey(autoGenerate = true) var id : Int? = null,
    var word:String? = "",
    @Ignore val counter:Int? = 0,

    @ColumnInfo(name = "createdDate") var createdDate: Date = Date(),

    @ColumnInfo(defaultValue = "0") var year : Int = 0
)
