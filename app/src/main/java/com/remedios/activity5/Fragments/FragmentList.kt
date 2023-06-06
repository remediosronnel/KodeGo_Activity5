package com.remedios.activity5.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.remedios.activity5.Adapter.*
import com.remedios.activity5.DetailActivity
import com.remedios.activity5.R
import com.remedios.activity5.databinding.FragmentListBinding
import com.remedios.activity5.Adapter.Book



class FragmentList : Fragment(), BookClickListener {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        populateBooks()

        val fragmentList = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(activity?.applicationContext, 3)
            adapter = CardAdapter(bookList, fragmentList)
        }



        return binding.root


    }
    override fun onClick(book: Book) {
        val intent = Intent(activity?.applicationContext, DetailActivity::class.java)
        intent.putExtra(BOOK_ID_EXTRA, book.id)
        startActivity(intent)
    }

    private fun populateBooks() {
        val book1 = Book(
            R.drawable.img_the_art,
            "The Dalai Lama",
            "The Art of Happiness",
            "he Art of Happiness: A Handbook for Living is a practical, inspirational guide that combines the wisdom of the Dalai Lama's eastern spiritual tradition with human happiness expert Dr Howard C. Cutler's western perspective.\n" +
                    "\n" + "From health, self-esteem, family and relationships to anger, stress, anxiety and jealousy, they apply the principles of Tibetan Buddhism to everyday problems and reveal how we can find balance and achieve lasting happiness in our lives.\n" +
                    "\n" + "Mental wellbeing and the power of positive psychology have never been so important, and, more than ever, people are turning to the world's great spiritual leaders in their search for meaning. The Art of Happiness is a landmark book that will continue to uplift spirits around the world for decades to come.",
            1, "900.00"
        )
        bookList.add(book1)
        val book2 = Book(
            R.drawable.img_android_cookbook,
            "Ian Darwin",
            "Android:Cookbook: Problems and Solutions for Android Developers",
            "The Art of Happiness: A Handbook for Living is a practical, inspirational guide that combines the wisdom of the Dalai Lama's eastern spiritual tradition with human happiness expert Dr Howard C. Cutler's western perspective.\\n\" +\n" +
                    "                    \"\\n\" + \"From health, self-esteem, family and relationships to anger, stress, anxiety and jealousy, they apply the principles of Tibetan Buddhism to everyday problems and reveal how we can find balance and achieve lasting happiness in our lives.\\n\" +\n" +
                    "                    \"\\n\" + \"Me",
            2, "478.55"
        )
        bookList.add(book2)

        val book3 = Book(
            R.drawable.img_android_programming_pushing_the_limits,
            "Erik Hellman",
            "Android Programming: Pushing the Limits 1st Edition",
            "If you already know your way around the Android OS and can build a simple Android app in under an hour, this book is for you. If you’re itching to see just how far you can push it and discover what Android is really capable of, it’s for you. And if you’re ready to learn how to build advanced, intuitive, innovative apps that are a blast to use, this book is definitely for you",
            3, "789"
        )
        bookList.add(book3)

        val book4 = Book(
            R.drawable.img_android_programming_the_big_nerd_ranch_guide,
            "Bill Phillips",
            "Android programming: The Big Nerd Ranch Guide 3rd Edition",
            "If you already know your way around the Android OS and can build a simple Android app in under an hour, this book is for you. If you’re itching to see just how far you can push it and discover what Android is really capable of, it’s for you. And if you’re ready to learn how to build advanced, intuitive, innovative apps that are a blast to use, this book is definitely for you",
            4, "768.75"
        )
        bookList.add(book4)

        val book5 = Book(
            R.drawable.img_android_studio_development_essentials,
            "Niel Smyth",
            "Android Studio 3.0 Development Essentials - Android 8 Edition",
            "Fully updated for Android Studio 3.0 and Android 8, the goal of this book is to teach the skills necessary to develop Android based applications using the Android Studio Integrated Development Environment (IDE), the Android 8 Software Development Kit (SDK) and the Java programming language.\n" +
                    "\n" + "Beginning with the basics, this book provides an outline of the steps necessary to set up an Android development and testing environment. An overview of Android Studio is included covering areas such as tool windows, the code editor and the Layout Editor tool. An introduction to the architecture of Android is followed by an in-depth look at the design of Android applications and user interfaces using the Android Studio environment. More advanced topics such as database management, content providers and intents are also covered, as are touch screen handling, gesture recognition, camera access and the playback and recording of both video and audio. This edition of the book also covers printing, transitions and cloud-based file storage.",
            5, "854.45"
        )
        bookList.add(book5)

        val book6 = Book(
            R.drawable.img_android_studio_development_essentials,
            "Mark L. Murphy",
            "The Busy Coder's Guide to Android Development",
            "Java Programming & Application Development for Google/Open Handset Alliance Mobile Phones & Internet Devices",
            6, "872.12"
        )
        bookList.add(book6)

        val book7 = Book(
            R.drawable.img_how_to_talk_about_jesus,
            "Sam Chan",
            "How to Talk about Jesus (Without Being That Guy)",
            "Most Christians know they should be trying to tell their friends and family about Jesus. But in a post-Christendom world, personal evangelism is viewed negatively--it's offensive, inappropriate, and insensitive. Recent studies confirm that the majority of Christians rarely evangelize, worried they might offend their family or lose their friends. In How to Talk About Jesus (Without Being That Guy), author Sam Chan equips everyday Christians who are reluctant and nervous to tell their friends about Jesus with practical, tested ways of sharing their faith in the least awkward ways possible.\n" +
                    "\n" + "Drawing from over two decades of experience as an evangelist, teacher, and pastor, Chan explains why personal evangelism feels so awkward today. And utilizing recent insights from communication theory, cross-cultural ministry, and apologetics, he helps you build confidence in sharing your faith, and teaches you how to evangelize your friends and family in socially appropriate ways.",
            7, "698.78"
        )
        bookList.add(book7)

        bookList.add(book1)
        bookList.add(book2)
        bookList.add(book3)
        bookList.add(book4)
        bookList.add(book5)
        bookList.add(book6)
        bookList.add(book7)
    }
}
