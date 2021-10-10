package com.mytube.android.data

import com.google.gson.annotations.SerializedName

data class YouTubeVideoListResponse (
    @SerializedName("kind") val kind : String,
    @SerializedName("etag") val etag : String,
    @SerializedName("items") val items : List<YouTubeVideo>,
    @SerializedName("nextPageToken") val nextPageToken : String,
    @SerializedName("pageInfo") val pageInfo : PageInfo
)