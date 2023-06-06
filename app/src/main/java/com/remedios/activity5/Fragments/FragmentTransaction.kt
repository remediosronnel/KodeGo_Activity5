package com.remedios.activity5.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.remedios.activity5.Adapter.CardAdapter
import com.remedios.activity5.Adapter.CardAdapter2
import com.remedios.activity5.Adapter.bookList
import com.remedios.activity5.Adapter.bookList2


import com.remedios.activity5.databinding.FragmentTransactionBinding


class FragmentTransaction : Fragment() {

    private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter:CardAdapter2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransactionBinding.inflate(inflater, container, false)


        binding.recyclerView1.setHasFixedSize(true)
        binding.recyclerView1.layoutManager = LinearLayoutManager(context)



        binding.recyclerView1.apply {
            layoutManager = GridLayoutManager(activity?.applicationContext, 1)
            adapter = CardAdapter2(bookList)
            binding.recyclerView1.adapter = adapter
        }


        return binding.root
    }


}