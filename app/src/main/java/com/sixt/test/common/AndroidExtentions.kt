package com.sixt.test.common

import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.sixt.test.R

fun AppCompatImageView.loadImage(url: String?, @DrawableRes resId : Int = R.drawable.ic_warning_black_24dp) {
    url?.let {
        Glide.with(this).load(url).centerInside().error(resId).into(this)
    } ?: setImageResource(resId)
}