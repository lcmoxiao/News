package com.banmo.news

import android.content.Context
import android.util.AttributeSet
import android.widget.VideoView

class FullVideoView : VideoView {

    constructor(con: Context) : super(con)
    constructor(con: Context, attributeSet: AttributeSet) : super(con, attributeSet)
    constructor(con: Context, attributeSet: AttributeSet, de: Int) : super(con, attributeSet, de)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(
            getDefaultSize(0, widthMeasureSpec),
            getDefaultSize(0, heightMeasureSpec)
        )
    }


}