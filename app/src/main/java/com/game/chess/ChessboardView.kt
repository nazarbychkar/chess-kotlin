package com.game.chess

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View

class ChessboardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
//    private final val whiteColor = Color.rgb(255, 255, 240)
    private final val whiteColor = Color.CYAN
    private final val blackColor = Color.rgb(11, 1, 0)

    private val displayMetrics = DisplayMetrics()
    private val height = displayMetrics.heightPixels
    private val width = displayMetrics.widthPixels

    private final val sizeRect = 130f / (height * width)
    private final val initialX = width - 20f
    private final val initialY = (height / 2) + (4 * sizeRect)

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