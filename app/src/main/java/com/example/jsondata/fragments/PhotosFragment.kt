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
import com.example.jsondata.adapter.RecyclerViewPhotoAdapter
import com.example.jsondata.model.photos.Photos
import com.example.jsondata.viewModel.PhotoFragmentViewModel

class PhotosFragment : Fragment() {
    lateinit var recyclerViewPhotos: RecyclerView
    lateinit var arrayList: ArrayList<Photos>
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        arrayList = ArrayList()
        val view:View? = inflater.inflate(R.layout.fragment_photos, container, false)
        recyclerViewPhotos = view!!.findViewById(R.id.recyclerViewPhotos)
        recyclerViewPhotos.layoutManager = LinearLayoutManager(activity)

        val viewModelProvider:PhotoFragmentViewModel = ViewModelProvider(this)[PhotoFragmentViewModel::class.java]
        viewModelProvider.apiCallGetPhotos()
        viewModelProvider.getLiveDataObserver().observe(viewLifecycleOwner, Observer {
            val photosItem = it
            arrayList.add(photosItem)
            addPhotoDetailsToRecyclerView(it)
        })


        return view
    }

    private fun addPhotoDetailsToRecyclerView(photosItem: Photos) {
        val recyclerViewPhotoAdapter = RecyclerViewPhotoAdapter(photosItem,this)
        recyclerViewPhotos.adapter = recyclerViewPhotoAdapter


    }


}