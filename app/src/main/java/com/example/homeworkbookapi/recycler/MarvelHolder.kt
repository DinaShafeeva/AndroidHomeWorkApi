package com.example.homeworkbookapi.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkbookapi.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.marvel_item.*
import com.example.homeworkbookapi.res.Result


class MarvelHolder (
    override val containerView: View,
    private val clickLambda: (Result) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(character: Result) {

        tv_name.text = character.name//.substring(0,character.name.indexOf('('))
        tv_full_name.text = character.name//.substring(character.name.indexOf('('),character.name.indexOf(')'))

        itemView.setOnClickListener {
            clickLambda(character)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Result) -> Unit) =
            MarvelHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.marvel_item,
                    parent,
                    false
                ),
                clickLambda
            )
    }
}
