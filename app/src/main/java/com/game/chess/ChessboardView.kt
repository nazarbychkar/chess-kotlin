package com.game.chess

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ChessboardView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
//    private final val whiteColor = Color.rgb(255, 255, 240)
    private val whiteColor = Color.CYAN
    private val blackColor = Color.rgb(11, 1, 0)

    private val displayMetrics = context.resources.displayMetrics
    private val height = displayMetrics.heightPixels
    private val width = displayMetrics.widthPixels

    private val sizeRect = width * 0.12f
    private val initialX = (width / 2) - (sizeRect * 4)
    private val initialY = (height / 2) - (sizeRect * 4)

    override fun onDraw(canvas: Canvas) {
        val paint = Paint()
        paint.color = whiteColor

        for (row in 0 until 8) {
            for (column in 0 until 8) {
                paint.color = if ((row + column) % 2 == 1) blackColor else whiteColor
                canvas.drawRect(
                    initialX + column * sizeRect,
                    initialY + row * sizeRect,
                    initialX + (column + 1)* sizeRect,
                    initialY + (row + 1) * sizeRect, paint
                )
            }
        }
    }
}