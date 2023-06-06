package com.remedios.activity5.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.remedios.activity5.databinding.CardCellBinding



class CardAdapter2 (var books:MutableList<Book>
): RecyclerView.Adapter<CardViewHolder2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder2 {
        var from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from, parent, false)
        return  CardViewHolder2(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder2, position: Int) {
        holder.bindBook(books[position])
    }

    fun setFilteredList(bookList:MutableList<Book>){
        this.books = bookList.toMutableList()
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = books.size

}