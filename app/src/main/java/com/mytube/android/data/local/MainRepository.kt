package com.mytube.android.data.local

import com.mytube.android.Constants
import com.mytube.android.data.remote.ApiInterface

class MainRepository constructor(private val apiInterface: ApiInterface) {

    fun getMostPopularVideos() = apiInterface.getVideos("mostPopular", Constants.API_KEY, "snippet", 10)
}