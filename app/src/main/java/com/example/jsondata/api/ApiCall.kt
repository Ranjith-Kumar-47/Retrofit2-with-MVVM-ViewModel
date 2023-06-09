package com.example.jsondata.api

import com.example.jsondata.model.photos.Photos
import com.example.jsondata.model.posts.Posts
import com.example.jsondata.model.users.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiCall {
    @GET("photos") //BASE URL = https://jsonplaceholder.typicode.com/photos
    fun getPhotos(): Call<Photos>

    @GET("posts")  //BASE URL = https://jsonplaceholder.typicode.com/posts
    fun getPosts():Call<Posts>

    @GET("users")  //BASE URL = https://jsonplaceholder.typicode.com/users
    fun getUsers():Call<Users>

}