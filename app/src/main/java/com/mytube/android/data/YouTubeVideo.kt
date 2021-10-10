package com.mytube.android.data

import com.google.gson.annotations.SerializedName

data class YouTubeVideo(
    @SerializedName("kind") val kind : String,
    @SerializedName("etag") val etag : String,
    @SerializedName("id") val id : String,
    @SerializedName("snippet") val snippet : Snippet,
    @SerializedName("contentDetails") val contentDetails : ContentDetails,
    @SerializedName("statistics") val statistics : Statistics
)

data class Snippet (
    @SerializedName("publishedAt") val publishedAt : String,
    @SerializedName("channelId") val channelId : String,
    @SerializedName("title") val title : String,
    @SerializedName("description") val description : String,
    @SerializedName("thumbnails") val thumbnails : Thumbnails,
    @SerializedName("channelTitle") val channelTitle : String,
    @SerializedName("categoryId") val categoryId : Int,
    @SerializedName("liveBroadcastContent") val liveBroadcastContent : String,
    @SerializedName("localized") val localized : Localized,
    @SerializedName("defaultAudioLanguage") val defaultAudioLanguage : String
)

data class Thumbnails(
    @SerializedName("default") val default : Default,
    @SerializedName("medium") val medium : Medium,
    @SerializedName("high") val high : High,
    @SerializedName("standard") val standard : Standard,
    @SerializedName("maxres") val maxres : Maxres
)

data class Default(
    @SerializedName("url") val url : String,
    @SerializedName("width") val width : Int,
    @SerializedName("height") val height : Int
)

data class Medium(
    @SerializedName("url") val url : String,
    @SerializedName("width") val width : Int,
    @SerializedName("height") val height : Int
)

data class High(
    @SerializedName("url") val url : String,
    @SerializedName("width") val width : Int,
    @SerializedName("height") val height : Int
)

data class Standard(
    @SerializedName("url") val url : String,
    @SerializedName("width") val width : Int,
    @SerializedName("height") val height : Int
)

data class Maxres(
    @SerializedName("url") val url : String,
    @SerializedName("width") val width : Int,
    @SerializedName("height") val height : Int
)

data class Localized(
    @SerializedName("title") val title : String,
    @SerializedName("description") val description : String
)

data class ContentDetails (
    @SerializedName("duration") val duration : String,
    @SerializedName("dimension") val dimension : String,
    @SerializedName("definition") val definition : String,
    @SerializedName("caption") val caption : Boolean,
    @SerializedName("licensedContent") val licensedContent : Boolean,
    @SerializedName("projection") val projection : String
)

data class Statistics (

    @SerializedName("viewCount") val viewCount : Int,
    @SerializedName("likeCount") val likeCount : Int,
    @SerializedName("dislikeCount") val dislikeCount : Int,
    @SerializedName("favoriteCount") val favoriteCount : Int,
    @SerializedName("commentCount") val commentCount : Int
)