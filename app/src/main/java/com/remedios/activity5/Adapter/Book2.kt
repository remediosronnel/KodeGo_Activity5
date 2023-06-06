package com.remedios.activity5.Adapter


var bookList2 = mutableListOf<Book2>()

open class Book2 (
    var cover:Int,
    var author:String,
    var title:String,
    var description:String,
    val id:Int? = bookList2.size,
    var price:String
)