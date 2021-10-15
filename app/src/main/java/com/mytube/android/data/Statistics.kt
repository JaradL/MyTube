package com.mytube.android.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Statistics (
    @SerializedName("viewCount") val viewCount : Int,
    @SerializedName("likeCount") val likeCount : Int,
    @SerializedName("dislikeCount") val dislikeCount : Int,
    @SerializedName("favoriteCount") val favoriteCount : Int,
    @SerializedName("commentCount") val commentCount : Int
): Parcelable