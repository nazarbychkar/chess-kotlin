package com.game.chess

class GameModel {
    var pieces = mutableSetOf<Piece>()

    init {
        reset()
    }

    fun pieceAt(row: Int, column: Int): Piece? {
        for (piece in pieces) {
            if (row == piece.row && column == piece.column) {
                return piece
            }
        }
        return null
    }

    fun reset() {
        pieces.removeAll(pieces)

        pieces.add(
            Piece(
                0, 4, RANK.KING, COLOR.WHITE, R.drawable.white_king
            )
        )
        pieces.add(
            Piece(
                7, 4, RANK.KING, COLOR.BLACK, R.drawable.black_king
            )
        )

        pieces.add(
            Piece(
                0, 3, RANK.QUEEN, COLOR.WHITE, R.drawable.white_queen
            )
        )
        pieces.add(
            Piece(
                7, 3, RANK.QUEEN, COLOR.BLACK, R.drawable.black_queen
            )
        )

        for (set in 0..7) {
            pieces.add(
                Piece(
                    1,
                    set,
                    RANK.PAWN,
                    COLOR.WHITE,
                    R.drawable.white_pawn
                )
            )
            pieces.add(
                Piece(
                    6,
                    set,
                    RANK.PAWN,
                    COLOR.BLACK,
                    R.drawable.black_pawn
                )
            )
        }

        for (set in 0..1) {
            pieces.add(
                Piece(
                    0,
                    2 + set * 3,
                    RANK.BISHOP,
                    COLOR.WHITE,
                    R.drawable.white_bishop
                )
            )
            pieces.add(
                Piece(
                    7,
                    2 + set * 3,
                    RANK.BISHOP,
                    COLOR.BLACK,
                    R.drawable.black_bishop
                )
            )

            pieces.add(
                Piece(
                    0,
                    1 + set * 5,
                    RANK.KNIGHT,
                    COLOR.WHITE,
                    R.drawable.white_knight
                )
            )
            pieces.add(
                Piece(
                    7,
                    1 + set * 5,
                    RANK.KNIGHT,
                    COLOR.BLACK,
                    R.drawable.black_knight
                )
            )

            pieces.add(
                Piece(
                    0,
                    0 + set * 7,
                    RANK.ROOK,
                    COLOR.WHITE,
                    R.drawable.white_rook
                )
            )
            pieces.add(
                Piece(
                    7,
                    0 + set * 7,
                    RANK.ROOK,
                    COLOR.BLACK,
                    R.drawable.black_rook
                )
            )
        }
    }
}