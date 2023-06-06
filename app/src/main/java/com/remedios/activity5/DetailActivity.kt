package com.remedios.activity5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.remedios.activity5.Adapter.BOOK_ID_EXTRA
import com.remedios.activity5.Adapter.Book2
import com.remedios.activity5.Adapter.bookList2
import com.remedios.activity5.databinding.ActivityDetailsBinding
import com.remedios.activity5.databinding.FragmentListBinding


class DetailActivity: AppCompatActivity(){
    private lateinit var binding : ActivityDetailsBinding
    private var addedBook = mutableListOf<Book2>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Book Details"

        val bookID = intent.getIntExtra(BOOK_ID_EXTRA, -1)
        var book2 = bookFromID(bookID)


        if (book2 != null){

            binding.cover.setImageResource(book2.cover)
            binding.tvTitle.text = book2.title
            binding.tvDescription.text = book2.description
            binding.tvAuthor.text = book2.author
            binding.tvPrice.text = book2.price


        }
        if (book2 != null) {
            addBooks(book2)
        }

        binding.back.setOnClickListener{
            val intent = Intent(applicationContext, FragmentListBinding::class.java)
            startActivity(intent)
        }
        }


    private fun bookFromID(bookID:Int) : Book2?{
       for (book2 in bookList2){
           if(book2.id == bookID){
               return book2
           }
       }
        return null
    }
    private fun addBooks(book2: Book2) {
        binding.addCart.setOnClickListener {
            if (book2 != null) {
                addedBook.add(book2)
                Toast.makeText(applicationContext, "Successfully Added", Toast.LENGTH_SHORT).show()
            }
        }
    }


}