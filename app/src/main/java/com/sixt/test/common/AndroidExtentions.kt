package com.sixt.test.common

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.bumptech.glide.Glide
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.sixt.test.R

fun AppCompatImageView.loadImage(url: String?, @DrawableRes resId: Int = R.drawable.ic_warning_black_24dp) {
    url?.let {
        Glide.with(this).load(url).error(resId).into(this)
    } ?: setImageResource(resId)
}

fun GoogleMap.iconForDelivery(context: Context): BitmapDescriptor {
    return BitmapDescriptorFactory.fromBitmap(
        getBitmapFromDrawable(context, R.drawable.ic_directions_car)
    )
}

private fun getBitmapFromDrawable(context: Context, @DrawableRes drawableRes: Int): Bitmap {
    return getBitmapFromDrawable(ContextCompat.getDrawable(context, drawableRes)!!)
}

private fun getBitmapFromDrawable(drawable: Drawable): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && drawable is VectorDrawable) {
        getBitmap(drawable)
    } else if (drawable is VectorDrawableCompat)
        getBitmap(drawable)
    else (drawable as BitmapDrawable).bitmap
}

private fun getBitmap(vectorDrawable: Drawable): Bitmap {
    val bitmap = Bitmap.createBitmap(
        vectorDrawable.intrinsicWidth,
        vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
    vectorDrawable.draw(canvas)
    return bitmap
}