package com.example.jsondata.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jsondata.instance.RetrofitInstance
import com.example.jsondata.model.photos.Photos
import com.example.jsondata.model.posts.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsFragmentViewModel : ViewModel() {
    val mutableLiveData: MutableLiveData<Posts> = MutableLiveData()
    fun getLiveDataObserver(): MutableLiveData<Posts> {
        return mutableLiveData
    }
    fun apiCallGetPosts() {
        RetrofitInstance.getInstance().getPosts().enqueue(object : Callback<Posts> {
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
                mutableLiveData.postValue(null)
            }

        })

    }
}