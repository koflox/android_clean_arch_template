package com.koflox.cleanarch.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.koflox.cleanarch.util.notNull

@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun <T> setData(recyclerView: RecyclerView, data: List<T>?) {
    notNull(recyclerView.adapter as? BindableAdapter<T>, data) { adapter, list ->
        adapter.setData(list)
    }
}