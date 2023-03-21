package com.example.jsondata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsondata.R
import com.example.jsondata.model.users.Users

class RecyclerViewUsersAdapter(private val arrayList: Users) : RecyclerView.Adapter<RecyclerViewUsersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.users_card_design, parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = arrayList[position].name
        holder.tvUserName.text = "(@${arrayList[position].username})"
        holder.tvEmail.text = arrayList[position].email
        holder.tvStreet.text = arrayList[position].address.street
        holder.tvSuite.text = arrayList[position].address.suite
        holder.tvCity.text = arrayList[position].address.city
        holder.tvZipCode.text = arrayList[position].address.zipcode
        holder.tvLat.text = arrayList[position].address.geo.lat
        holder.tvLng.text = arrayList[position].address.geo.lng
    }

    override fun getItemCount() = arrayList.size

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvName:TextView = view.findViewById(R.id.tvName)
        val tvUserName:TextView = view.findViewById(R.id.tvUserName)
        val tvEmail:TextView = view.findViewById(R.id.tvEmail)
        val tvStreet:TextView = view.findViewById(R.id.tvStreet)
        val tvSuite:TextView = view.findViewById(R.id.tvSuite)
        val tvCity:TextView = view.findViewById(R.id.tvCity)
        val tvZipCode:TextView = view.findViewById(R.id.tvZipCode)
        val tvLat:TextView = view.findViewById(R.id.tvLat)
        val tvLng:TextView = view.findViewById(R.id.tvLng)

    }
}
