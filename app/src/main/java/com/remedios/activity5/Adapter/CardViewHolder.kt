package com.remedios.activity5.Adapter

import androidx.recyclerview.widget.RecyclerView
import com.remedios.activity5.databinding.CardCellBinding

class CardViewHolder(
    private val cardCellBinding: CardCellBinding,
    private val clickListener: BookClickListener

):RecyclerView.ViewHolder(cardCellBinding.root) {

    fun bindBook(book: Book){
        cardCellBinding.cover.setImageResource(book.cover)
        cardCellBinding.tvTitle.text = book.title
        cardCellBinding.tvAuthor.text = book.author


        cardCellBinding.cardView.setOnClickListener {
            clickListener.onClick(book)
        }
    }
}