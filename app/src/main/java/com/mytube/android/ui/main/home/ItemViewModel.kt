package com.mytube.android.ui.main.home

import androidx.annotation.LayoutRes
import com.mytube.android.R
import com.mytube.android.data.YouTubeVideo

interface ItemViewModel {
    @get:LayoutRes
    val layoutId: Int
    val viewType: Int
        get() = 0
}

class HomeVideoViewModel(val video: YouTubeVideo): ItemViewModel {
    override val layoutId: Int = R.layout.item_home_video
    override val viewType: Int = 0
}