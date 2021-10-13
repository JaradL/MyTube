package com.mytube.android.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.mytube.android.R
import com.mytube.android.ui.main.HomeActivity
import com.mytube.android.ui.video.VideoPlayerFragment

class BindableRecyclerViewAdapter : RecyclerView.Adapter<BindableViewHolder>() {

    var itemViewModels: List<ItemViewModel> = emptyList()
    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?: 0,
            parent,
            false)
        return BindableViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemViewModels[position]
        if (!viewTypeToLayoutId.containsKey(item.viewType)) {
            viewTypeToLayoutId[item.viewType] = item.layoutId
        }
        return item.viewType
    }

    override fun getItemCount(): Int = itemViewModels.size

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        holder.bind(itemViewModels[position])
        holder.itemView.setOnClickListener {
            val activity = it.context as HomeActivity
            activity.supportFragmentManager.commit {
                add(android.R.id.content, VideoPlayerFragment.newInstance())
                setReorderingAllowed(true)
                addToBackStack(null)
            }
//            holder.itemView.context.startActivity(Intent(holder.itemView.context, VideoPlayerActivity::class.java))
        }
    }

    fun updateItems(items: List<ItemViewModel>?) {
        itemViewModels = items ?: emptyList()
        notifyDataSetChanged()
    }
}

class BindableViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(itemViewModel: ItemViewModel) {
        binding.setVariable(BR.itemViewModel, itemViewModel)
    }
}