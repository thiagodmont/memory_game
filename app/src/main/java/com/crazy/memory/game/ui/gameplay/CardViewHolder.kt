package com.crazy.memory.game.ui.gameplay

import android.view.View
import com.crazy.memory.game.base.BaseViewHolder
import com.crazy.memory.game.databinding.ItemCardBinding
import com.crazy.memory.game.domain.model.CardModel

internal class CardViewHolder(
    private val viewBinding: ItemCardBinding,
    private val onClick: CardAdapter.OnItemClickListener?,
): BaseViewHolder(viewBinding) {

    fun binding(card: CardModel) {
        if (card.flipped) {
            viewBinding.mtvCardFront.setImageResource(card.drawable)
            viewBinding.mtvCardFront.visibility = View.VISIBLE
            viewBinding.mtvCardBack.visibility = View.GONE
        } else {
            viewBinding.mtvCardBack.visibility = View.VISIBLE
            viewBinding.mtvCardFront.visibility = View.GONE
        }

        viewBinding.mtvCardBack.setOnClickListener {
            if (card.flipped.not() && card.matched.not()) {
                viewBinding.mtvCardFront.setImageResource(card.drawable)
                viewBinding.mtvCardFront.visibility = View.VISIBLE

                onClick?.onItemClick(card)
            }
        }
    }
}