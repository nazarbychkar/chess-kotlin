package com.game.chess

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class ChessboardView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val whiteColor = Color.CYAN
    private val blackColor = Color.GRAY

    private val displayMetrics = context.resources.displayMetrics
    private val height = displayMetrics.heightPixels
    private val width = displayMetrics.widthPixels

    private val sizeRect = width * 0.12f
    private val initialX = (width / 2) - (sizeRect * 4)
    private val initialY = (height / 2) - (sizeRect * 4)

    private val paint = Paint()

    private final val bitmaps = mutableMapOf<Int, Bitmap>()
    private final val piecesIds = setOf(
        R.drawable.white_king,
        R.drawable.black_king,
        R.drawable.white_queen,
        R.drawable.black_queen,
        R.drawable.white_rook,
        R.drawable.black_rook,
        R.drawable.white_bishop,
        R.drawable.black_bishop,
        R.drawable.white_knight,
        R.drawable.black_knight,
        R.drawable.white_pawn,
        R.drawable.black_pawn,
    )

    init {
        piecesIds.forEach {
            bitmaps[it] = BitmapFactory.decodeResource(resources, it)
        }
    }

    override fun onDraw(canvas: Canvas) {
        drawChessBoard(canvas)
        drawPieces(canvas)
    }

    private fun drawPieces(canvas: Canvas) {
        val model = GameModel()
        model.reset()

        for (row in 0..7) {
            for (column in 0..7) {
                val piece = model.pieceAt(row, column)
                if (piece != null) {
                    val bitmap = bitmaps[piece.imagePngId]!!
                    canvas.drawBitmap(
                        bitmap,
                        null,
                        RectF(
                            initialX + column * sizeRect,
                            initialY + (7 - row) * sizeRect,
                            initialX + (column + 1) * sizeRect,
                            initialY + ((7 - row) + 1) * sizeRect
                        ),
                        paint
                    )
                }
            }
        }
    }

    private fun drawChessBoard(canvas: Canvas) {
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