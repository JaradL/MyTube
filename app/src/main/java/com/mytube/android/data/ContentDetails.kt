package com.mytube.android.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContentDetails (
    @SerializedName("duration") val duration : String,
    @SerializedName("dimension") val dimension : String,
    @SerializedName("definition") val definition : String,
    @SerializedName("caption") val caption : Boolean,
    @SerializedName("licensedContent") val licensedContent : Boolean,
    @SerializedName("projection") val projection : String
): Parcelable