package com.mytube.android.data.remote

import com.mytube.android.Constants
import com.mytube.android.data.YouTubeVideoListResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("videos")
    fun getVideos(
        @Query("chart") chartType: String,
        @Query("key") apiKey: String,
        @Query("part") part: String,
        @Query("maxResults") maxResults: Int
    ) : Call<YouTubeVideoListResponse>

    companion object {
        fun create() : ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.URL_YOUTUBE_API)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}