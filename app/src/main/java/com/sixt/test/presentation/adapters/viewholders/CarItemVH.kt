package com.sixt.test.presentation.adapters.viewholders

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.sixt.test.common.loadImage
import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.adapters.OnItemClickListener
import kotlinx.android.synthetic.main.list_car_ui_item.view.*

class CarItemVH(
    parent: ViewGroup, @LayoutRes layoutId: Int,
    private var onItemClickListener: OnItemClickListener<CarUIItem>?
) :
    BaseViewHolder<CarUIItem>(parent, layoutId) {

    override fun bind(item: CarUIItem) {
        itemView.list_car_ui_model_name_value.text = item.name
        itemView.list_car_ui_group_value.text = item.group
        itemView.list_car_ui_model_color_value.text = item.color
        itemView.list_car_ui_image.loadImage(item.carImageUrl)
        itemView.setOnClickListener { onItemClickListener?.onItemClick(item) }
    }

}