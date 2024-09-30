package com.vereshchagin.nikolay.hh_clone.core_ui.presentation.list

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecorator(
    private val start: Int = 0,
    private val top: Int = 0,
    private val end: Int = 0,
    private val bottom: Int = 0,
    private val includeLast: Boolean = false
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (includeLast || (parent.getChildAdapterPosition(view) != state.itemCount - 1)) {
            outRect.top = top
            outRect.left = start
            outRect.right = end
            outRect.bottom = bottom
        }
    }
}