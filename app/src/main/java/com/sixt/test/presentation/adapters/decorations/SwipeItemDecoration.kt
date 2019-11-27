package com.sixt.test.presentation.adapters.decorations

import android.graphics.Canvas
import androidx.recyclerview.widget.RecyclerView
import com.sixt.test.presentation.adapters.controllers.BaseSwipeController

class SwipeItemDecoration(
    private val swipeController: BaseSwipeController
) : RecyclerView.ItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        swipeController.onDraw(c)
    }
}