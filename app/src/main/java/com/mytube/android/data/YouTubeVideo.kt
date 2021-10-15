package com.mytube.android.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class YouTubeVideo(
    @SerializedName("kind") val kind : String,
    @SerializedName("etag") val etag : String,
    @SerializedName("id") val id : String,
    @SerializedName("snippet") val snippet : Snippet,
    @SerializedName("contentDetails") val contentDetails : ContentDetails,
    @SerializedName("statistics") val statistics : Statistics
) : Parcelable