package com.remedios.activity5.Fragments

import android.app.DownloadManager.Query
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.remedios.activity5.Adapter.*
import com.remedios.activity5.databinding.FragmentSearchBinding
import java.util.*
import kotlin.collections.ArrayList


class FragmentSearch() : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CardAdapter2
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)


        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = CardAdapter2(bookList)
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(activity?.applicationContext, 3)
            adapter = CardAdapter2(bookList)
        }
        binding.searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

        return binding.root
    }

    fun filterList(query: String?){
        if (query != null){
            val filteredList = ArrayList<Book>()
            for(book in bookList){
                if(book.title.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(book)
                }
            }
            if (filteredList.isEmpty()){
                Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show()
            }else{
                adapter.setFilteredList(filteredList)
            }
        }

    }

}



