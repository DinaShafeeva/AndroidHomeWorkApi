package com.example.homeworkbookapi.recycler

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.example.homeworkbookapi.res.Result


object Diff  : DiffUtil.ItemCallback<Result>() {

    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
        oldItem.description == newItem.description

    override fun getChangePayload(oldItem: Result, newItem: Result): Any? {
        val diffBundle = Bundle()
        if (oldItem.name != newItem.name) {
            diffBundle.putString("name", newItem.name)
        }
        if (oldItem.description != newItem.description) {
            diffBundle.putString("author", newItem.description)
        }
        return if (diffBundle.isEmpty) null else diffBundle
    }
}
