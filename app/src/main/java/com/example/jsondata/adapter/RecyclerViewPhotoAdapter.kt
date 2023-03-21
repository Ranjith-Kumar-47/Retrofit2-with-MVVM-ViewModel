package com.example.jsondata.adapter

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.jsondata.R
import com.example.jsondata.fragments.PhotosFragment
import com.example.jsondata.model.photos.Photos

class RecyclerViewPhotoAdapter(
    private val arrayList: Photos,
    private val fragmentActivity: PhotosFragment,
    private val context: Context
) :
    RecyclerView.Adapter<RecyclerViewPhotoAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.photos_card_design, parent, false)
        return MyViewHolder(view)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = arrayList[position].title
        holder.album1.text = arrayList[position].albumId.toString()
        holder.id1.text = arrayList[position].id.toString()
        Glide.with(fragmentActivity).load(arrayList[position].thumbnailUrl).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageViewImage)
        holder.imageViewImage.setOnClickListener {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.large_profile_image)
            val imageView:ImageView = dialog.findViewById(R.id.ivImage)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            Glide.with(context).load(arrayList[position].url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView)
            dialog.setCancelable(true)
            dialog.show()
        }

    }

    override fun getItemCount() = arrayList.size

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewImage: ImageView = view.findViewById(R.id.imageView)
        val title: TextView = view.findViewById(R.id.title)
        val album1: TextView = view.findViewById(R.id.album1)
        val id1: TextView = view.findViewById(R.id.id1)


    }
}