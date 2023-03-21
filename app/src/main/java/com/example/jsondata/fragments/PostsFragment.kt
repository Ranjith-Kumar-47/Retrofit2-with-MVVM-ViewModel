package com.example.jsondata.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsondata.R
import com.example.jsondata.adapter.RecyclerViewPostsAdapter
import com.example.jsondata.model.posts.Posts
import com.example.jsondata.viewModel.PostsFragmentViewModel

class PostsFragment : Fragment() {
    lateinit var recyclerViewPosts: RecyclerView
    lateinit var arrayList: ArrayList<Posts>
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View? = inflater.inflate(R.layout.fragment_posts, container, false)
        arrayList = ArrayList()
        recyclerViewPosts = view!!.findViewById(R.id.recyclerViewPosts)
        recyclerViewPosts.layoutManager = LinearLayoutManager(activity)

        val viewModelProvider = ViewModelProvider(this)[PostsFragmentViewModel::class.java]
        viewModelProvider.apiCallGetPosts()
        viewModelProvider.getLiveDataObserver().observe(viewLifecycleOwner, Observer {
            val photosItem = it
            arrayList.add(photosItem)
            addPhotoDetailsToRecyclerView(it)
        })


        return view
    }

    private fun addPhotoDetailsToRecyclerView(postsItem: Posts) {
        val recyclerViewPostsAdapter = RecyclerViewPostsAdapter(postsItem)
        recyclerViewPosts.adapter = recyclerViewPostsAdapter


    }

}