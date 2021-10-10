package com.mytube.android.ui.main.home

import androidx.annotation.LayoutRes
import com.mytube.android.R

interface ItemViewModel {
    @get:LayoutRes
    val layoutId: Int
    val viewType: Int
        get() = 0
}