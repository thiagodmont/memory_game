package com.crazy.memory.game.domain.model

data class CardModel(
    val drawable: Int,
    val key: String,
    var flipped: Boolean = false,
    var matched: Boolean = false
)