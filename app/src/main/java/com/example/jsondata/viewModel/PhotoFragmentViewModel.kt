package com.example.jsondata.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jsondata.instance.RetrofitInstance
import com.example.jsondata.model.photos.Photos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoFragmentViewModel : ViewModel() {

    val mutableLiveData: MutableLiveData<Photos> = MutableLiveData()
    fun getLiveDataObserver():MutableLiveData<Photos>{
        return mutableLiveData
    }
    fun apiCallGetPhotos() {
        RetrofitInstance.getInstance().getPhotos().enqueue(object : Callback<Photos> {
            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Photos>, t: Throwable) {
                mutableLiveData.postValue(null)
            }

        })

    }

}