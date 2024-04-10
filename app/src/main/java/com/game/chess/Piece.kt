package com.game.chess

import com.game.chess.RANK

data class Piece(
    val row: Int,
    val column: Int,
    val rank: RANK,
    val color: COLOR,
    val imagePngId: Int
) {
}