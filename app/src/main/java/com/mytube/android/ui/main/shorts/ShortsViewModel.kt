package com.mytube.android.ui.main.shorts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShortsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is stories Fragment"
    }
    val text: LiveData<String> = _text
}