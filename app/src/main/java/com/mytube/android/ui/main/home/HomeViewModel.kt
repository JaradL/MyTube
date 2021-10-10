package com.mytube.android.ui.main.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mytube.android.data.YouTubeVideo
import com.mytube.android.data.YouTubeVideoListResponse
import com.mytube.android.data.local.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel constructor(private val repository: MainRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val videoList = MutableLiveData<List<YouTubeVideo>>()
    val errorMessage = MutableLiveData<String>()

    fun getMostPopularVideos() {

        val response = repository.getMostPopularVideos()
        response.enqueue(object : Callback<YouTubeVideoListResponse> {
            override fun onResponse(
                call: Call<YouTubeVideoListResponse>,
                response: Response<YouTubeVideoListResponse>
            ) {
                videoList.postValue(response.body()?.items)
            }

            override fun onFailure(call: Call<YouTubeVideoListResponse>, t: Throwable) {
                Log.e("Fuck", t.message.toString())
                errorMessage.postValue(t.message)
            }
        })
    }
}