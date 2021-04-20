package com.crazy.memory.game.store

import com.crazy.memory.game.R
import com.crazy.memory.game.domain.model.CardModel

class CardsContainer {
    companion object {
        private val list = listOf(
            CardModel(
                drawable = R.drawable.garbage_man_card,
                key = "garbage-man"
            ),
            CardModel(
                drawable = R.drawable.dragon_card,
                key = "dragon"
            ),
            CardModel(
                drawable = R.drawable.cow_card,
                key = "cow"
            ),
            CardModel(
                drawable = R.drawable.ghost_dog_card,
                key = "ghost-dog"
            ),
            CardModel(
                drawable = R.drawable.spider_card,
                key = "spider"
            ),
            CardModel(
                drawable = R.drawable.bat_card,
                key = "bat"
            ),
            CardModel(
                drawable = R.drawable.cat_card,
                key = "cat"
            ),
            CardModel(
                drawable = R.drawable.hen_card,
                key = "hen"
            ),
            CardModel(
                drawable = R.drawable.horse_card,
                key = "horse"
            ),
            CardModel(
                drawable = R.drawable.pig_card,
                key = "pig"
            )
        )

        fun getBoard(size: Int): List<CardModel> {
            val cards = size / 2

            val list = CardsContainer.list
            val items = (list.indices).shuffled().take(cards).toSet().toList()

            val allItems = items + items

            return allItems.mapIndexed { index, i ->
                list[i].copy(key = "${list[i].key}-$index")
            }.shuffled()
        }
    }
}