package com.remedios.activity5.Adapter

import androidx.recyclerview.widget.RecyclerView
import com.remedios.activity5.databinding.CardCellBinding


class CardViewHolder2(
    private val cardCellBinding: CardCellBinding


    ): RecyclerView.ViewHolder(cardCellBinding.root) {

    fun bindBook(book: Book){
        cardCellBinding.cover.setImageResource(book.cover)
        cardCellBinding.tvTitle.text = book.title
        cardCellBinding.tvAuthor.text = book.author

    }
}