package com.sixt.test.presentation.adapters

import android.view.ViewGroup
import com.sixt.test.R
import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.adapters.viewholders.CarItemVH

class CarListAdapter(private var onItemClickListener: OnItemClickListener<CarUIItem>?) :
    BaseAdapter<CarUIItem, CarItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarItemVH =
        CarItemVH(parent, R.layout.list_car_ui_item, onItemClickListener)

}