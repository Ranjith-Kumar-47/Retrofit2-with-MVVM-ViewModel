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
import com.example.jsondata.adapter.RecyclerViewUsersAdapter
import com.example.jsondata.model.users.Users
import com.example.jsondata.viewModel.UsersFragmentModelClass

class UsersFragment : Fragment() {
    private lateinit var recyclerViewUsers: RecyclerView
    private lateinit var arrayList: ArrayList<Users>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View? = inflater.inflate(R.layout.fragment_users, container, false)
        arrayList = ArrayList()
        recyclerViewUsers = view!!.findViewById(R.id.recyclerViewUsers)
        recyclerViewUsers.layoutManager = LinearLayoutManager(activity)

        val viewModelProvider = ViewModelProvider(this)[UsersFragmentModelClass::class.java]
        viewModelProvider.apiCallGetUsers()
        viewModelProvider.getLiveDataObserver().observe(viewLifecycleOwner, Observer {
            val photosItem = it
            arrayList.add(photosItem)
            addUsersDetailsToRecyclerView(it)
        })


        return view
    }

    private fun addUsersDetailsToRecyclerView(UsersItem: Users) {
        val recyclerViewUsersAdapter = RecyclerViewUsersAdapter(UsersItem)
        recyclerViewUsers.adapter = recyclerViewUsersAdapter


    }

}