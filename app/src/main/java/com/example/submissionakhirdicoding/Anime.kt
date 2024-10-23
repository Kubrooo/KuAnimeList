package com.example.submissionakhirdicoding

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anime(
    val name : String,
    val description : String,
    val photo : Int,
    val episode: Int,
    val detPhoto: Int
) : Parcelable
