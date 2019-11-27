package com.sixt.test.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.sixt.test.presentation.adapters.viewholders.BaseViewHolder

abstract class BaseAdapter<In, Vh : BaseViewHolder<In>>(
    private var list: MutableList<In> = mutableListOf()
) : RecyclerView.Adapter<Vh>() {

    override fun onBindViewHolder(holder: Vh, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = list.size

    fun getItems(): List<In>? = list

    fun setItems(list: List<In>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    open fun getItem(position: Int): In? = list.getOrNull(position)
}