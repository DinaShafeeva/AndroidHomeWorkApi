package com.example.homeworkbookapi.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.homeworkbookapi.res.Result


class DiffUtil (private val oldList: List<Result>, private val newList: List<Result>) :
    DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size
}
