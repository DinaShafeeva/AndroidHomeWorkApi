package com.example.homeworkbookapi.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.homeworkbookapi.res.Result


class MarvelAdapter(
    private var dataSource: List<Result>,
    private val clickLambda: (Result) -> Unit
) : ListAdapter<Result, MarvelHolder>(
    Diff
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelHolder =
        MarvelHolder.create(
            parent,
            clickLambda
        )

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: MarvelHolder, position: Int) =
        holder.bind(dataSource[position])

    fun updateList(newList: List<Result>) {
        androidx.recyclerview.widget.DiffUtil.calculateDiff(
            DiffUtil(
                this.dataSource,
                newList
            ),
            true
        )
            .dispatchUpdatesTo(this)
        this.dataSource = newList
    }
}
