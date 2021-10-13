package com.mytube.android.ui.main.home

import android.icu.text.CompactDecimalFormat
import android.os.Build
import android.text.format.DateUtils
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailView
import com.mytube.android.Constants
import org.ocpsoft.prettytime.PrettyTime
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor
import kotlin.math.log10

@BindingAdapter("itemViewModels")
fun bindItemViewModels(recyclerView: RecyclerView, itemViewModels: List<ItemViewModel>?) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateItems(itemViewModels)
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): BindableRecyclerViewAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is BindableRecyclerViewAdapter) {
        recyclerView.adapter as BindableRecyclerViewAdapter
    } else {
        val bindableRecyclerAdapter = BindableRecyclerViewAdapter()
        recyclerView.adapter = bindableRecyclerAdapter
        bindableRecyclerAdapter
    }
}

@BindingAdapter("thumbnailId")
fun loadThumbnail(view: YouTubeThumbnailView, videoID: String?) {
    var readyForLoadingYoutubeThumbnail = true
    if (!videoID.isNullOrEmpty() && readyForLoadingYoutubeThumbnail) {
        readyForLoadingYoutubeThumbnail = false
        view.initialize(Constants.API_KEY, object : YouTubeThumbnailView.OnInitializedListener {
            override fun onInitializationSuccess(
                youTubeThumbnailView: YouTubeThumbnailView?,
                youTubeThumbnailLoader: YouTubeThumbnailLoader?
            ) {
                youTubeThumbnailLoader?.setVideo(videoID)
                youTubeThumbnailLoader?.setOnThumbnailLoadedListener(object: YouTubeThumbnailLoader.OnThumbnailLoadedListener {
                    override fun onThumbnailLoaded(p0: YouTubeThumbnailView?, p1: String?) {
                        youTubeThumbnailLoader.release()
                    }

                    override fun onThumbnailError(
                        thumbnailView: YouTubeThumbnailView?,
                        errorReason: YouTubeThumbnailLoader.ErrorReason?
                    ) {
                        Log.d("Fuck", errorReason.toString())
                    }
                })
                readyForLoadingYoutubeThumbnail = true;
            }

            override fun onInitializationFailure(
                youTubeThumbnailView: YouTubeThumbnailView?,
                youTubeInitializationResult: YouTubeInitializationResult?
            ) {
                Log.d("Fuck", youTubeInitializationResult.toString())
                readyForLoadingYoutubeThumbnail = true;
            }
        })
    } else {
        Log.d("Fuck", "The hell it aint")
    }
}

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view).load(url).into(view)
    }
}

@BindingAdapter("convertToTimeString")
fun convertToTimeString(view: TextView, publishedAt: String) {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    try {
        val time = sdf.parse(publishedAt)
        val prettyTime = PrettyTime()
        val niceDateStr = DateUtils.getRelativeTimeSpanString(time.time, Calendar.getInstance().timeInMillis, DateUtils.MINUTE_IN_MILLIS)
        view.text = niceDateStr
//        view.text = prettyTime.format(Date(time))
    } catch (e: ParseException) {
        Log.e("ConvertToTime", e.message.toString())
    }
}

@BindingAdapter("shortenBigNumber")
fun shortenBigNumber(view: TextView, number: Int) {
    val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
    val numValue = number
    val value = floor(log10(numValue.toDouble())).toInt()
    val base = value / 3
    val num = if (value >= 3 && base < suffix.size) {
        DecimalFormat("#0.0").format(
            numValue / Math.pow(
                10.0,
                (base * 3).toDouble()
            )
        ) + suffix[base]
    } else {
        DecimalFormat("#,##0").format(numValue)
    }
    view.text = "$num views"
}