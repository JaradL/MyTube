package com.mytube.android.ui.video

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mytube.android.Constants
import com.mytube.android.R
import com.mytube.android.data.YouTubeVideo

class VideoPlayerFragment : Fragment() {

    private var video: YouTubeVideo? = null

    companion object {
        @JvmStatic
        fun newInstance(youTubeVideo: YouTubeVideo) = VideoPlayerFragment().apply {
            arguments = Bundle().apply {
                putParcelable(Constants.KEY_YOUTUBE_VIDEO, youTubeVideo)
            }
        }
    }

    private lateinit var viewModel: VideoPlayerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video_player, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getParcelable<YouTubeVideo>(Constants.KEY_YOUTUBE_VIDEO).let {
            video = it
            Log.d("Fuck", video?.snippet?.title!!)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideoPlayerViewModel::class.java)
    }
}