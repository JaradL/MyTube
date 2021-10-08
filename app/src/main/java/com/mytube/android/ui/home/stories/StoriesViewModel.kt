package com.mytube.android.ui.home.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StoriesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is stories Fragment"
    }
    val text: LiveData<String> = _text
}