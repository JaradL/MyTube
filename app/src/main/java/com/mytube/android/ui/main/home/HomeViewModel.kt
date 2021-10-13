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

    val data: LiveData<List<ItemViewModel>>
        get() = _data
    private val _data = MutableLiveData<List<ItemViewModel>>(emptyList())

    val errorMessage = MutableLiveData<String>()

    init {
        getMostPopularVideos()
    }

    fun getMostPopularVideos() {
        val response = repository.getMostPopularVideos()
        response.enqueue(object : Callback<YouTubeVideoListResponse> {
            override fun onResponse(
                call: Call<YouTubeVideoListResponse>,
                response: Response<YouTubeVideoListResponse>
            ) {
                val viewData = createViewData(response.body()?.items)
                _data.postValue(viewData)
            }

            override fun onFailure(call: Call<YouTubeVideoListResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    private fun createViewData(videos: List<YouTubeVideo>?): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        if (videos != null) {
            for (video in videos) {
                Log.d("Fuck", video.snippet.publishedAt)
                viewData.add(HomeVideoViewModel(video))
            }
        }
        return viewData
    }
}