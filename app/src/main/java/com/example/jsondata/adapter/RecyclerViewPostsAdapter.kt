package com.example.jsondata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsondata.R
import com.example.jsondata.model.posts.Posts

class RecyclerViewPostsAdapter(
    private val arrayList: Posts,
) :
    RecyclerView.Adapter<RecyclerViewPostsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.posts_card_design, parent, false)
        return MyViewHolder(view)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = arrayList[position].title
        holder.userId.text = arrayList[position].userId.toString()
        holder.id.text = arrayList[position].id.toString()
        holder.body.text = arrayList[position].body

    }

    override fun getItemCount() = arrayList.size

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val userId: TextView = view.findViewById(R.id.userId)
        val id: TextView = view.findViewById(R.id.id)
        val body:TextView = view.findViewById(R.id.body)


    }
}