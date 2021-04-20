package com.crazy.memory.game.ui.gameplay

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.crazy.memory.game.base.BaseViewModel
import com.crazy.memory.game.base.SingleLiveEvent
import com.crazy.memory.game.base.sendEvent
import com.crazy.memory.game.domain.model.CardModel
import com.crazy.memory.game.extensions.toLiveData
import com.crazy.memory.game.store.CardsContainer
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

class GamePlayViewModel(
    private val row: Int,
    private val column: Int
): BaseViewModel() {
    private val _boardList = MutableLiveData<List<CardModel>?>()
    val boardList = _boardList.toLiveData()

    private val _matched = SingleLiveEvent<Unit>()
    val matched = _matched.toLiveData()

    private val _unMatched = SingleLiveEvent<Unit>()
    val unMatched = _unMatched.toLiveData()

    private val _unFlipCards = SingleLiveEvent<List<CardModel?>?>()
    val unFlipCards = _unFlipCards.toLiveData()

    private val _waitUnFlip = SingleLiveEvent<Boolean>()
    val waitUnFlip = _waitUnFlip.toLiveData()

    private val _won = SingleLiveEvent<Unit>()
    val won = _won.toLiveData()

    private val _score = MutableLiveData<Int>()
    val score = _score.toLiveData()

    private var lastCardFlipped: CardModel? = null

    init {
        startGame()
    }

    fun startGame() {
        val size = row * column
        _boardList.value = CardsContainer.getBoard(size)
        _score.value = 0
    }

    fun flippedCard(key:  String) {
        val list = _boardList.value?.toList()
        val card = list?.find { it.key == key }
        card?.flipped = true

        _score.value = _score.value?.plus(1)

        if (card?.drawable == lastCardFlipped?.drawable) {
            list?.map {
                if (it.flipped && it.matched.not()) {
                    it.matched = true
                }
            }

            lastCardFlipped = null
            _matched.sendEvent(Unit)

            val hasWon = list?.filter { it.matched.not() }

            if (hasWon?.isEmpty() == true) {
                _won.sendEvent(Unit)
            }
        } else {
            if (lastCardFlipped == null) {
                lastCardFlipped = list?.find { it.key == key }
            } else {
                _waitUnFlip.sendEvent(true)
                _unMatched.sendEvent(Unit)

                viewModelScope.launch {
                    delay(TimeUnit.SECONDS.toMillis(1))
                    list?.map {
                        if (it.matched.not()) {
                            it.flipped = false
                        }
                    }

                    _unFlipCards.sendEvent(listOf(
                        lastCardFlipped,
                        card
                    ))

                    lastCardFlipped = null
                    _waitUnFlip.sendEvent(false)
                }
            }
        }
    }
}