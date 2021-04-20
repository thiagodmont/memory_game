package com.crazy.memory.game.ui.gameplay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crazy.memory.game.R
import com.crazy.memory.game.base.BaseViewHolder
import com.crazy.memory.game.databinding.ItemCardBinding
import com.crazy.memory.game.databinding.ItemCardLargeBinding
import com.crazy.memory.game.domain.model.CardModel

internal class CardAdapter(private val isLarge: Boolean) : RecyclerView.Adapter<BaseViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(model: CardModel)
    }

    private var onClick: OnItemClickListener? = null

    private var data: List<CardModel> = emptyList()

    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.onClick = clickListener
    }

    fun setList(list: List<CardModel>) {
        data = list
        notifyDataSetChanged()
    }

    fun changeItem(item: CardModel) {
        val index = data.indexOf(item)
        notifyItemChanged(index)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is CardViewHolder -> {
                holder.binding(data[position])
            }
            is CardLargeViewHolder -> {
                holder.binding(data[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType) {
            R.layout.item_card -> {
                CardViewHolder(
                    ItemCardBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ),
                    onClick
                )
            }
            R.layout.item_card_large -> {
                CardLargeViewHolder(
                    ItemCardLargeBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ),
                    onClick
                )
            }

            else -> throw IllegalArgumentException("Unexpected viewType received: $viewType.")
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = if (isLarge) R.layout.item_card_large else R.layout.item_card
}