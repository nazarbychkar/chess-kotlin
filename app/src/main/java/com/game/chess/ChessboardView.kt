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

        for (row in 0..7) {
            for (column in 0..7) {
                canvas.drawRect(
                    initialX + (column * sizeRect),
                    initialY + (row * sizeRect),
                    (initialX + sizeRect) + (column * sizeRect),
                    (initialY + sizeRect) + (column * sizeRect),
                    paint
                )
                paint.color = if (paint.color == whiteColor) blackColor else whiteColor
            }
            paint.color = if (paint.color == whiteColor) blackColor else whiteColor
        }
    }
}