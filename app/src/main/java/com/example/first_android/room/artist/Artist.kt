package com.example.first_android.room.artist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Artist(
    @PrimaryKey(autoGenerate = true) @ColumnInfo var id: Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "debut") var debut: String,
    @ColumnInfo(name = "origin_place") var originPlace: String) {}