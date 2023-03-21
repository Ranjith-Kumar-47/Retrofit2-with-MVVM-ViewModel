package com.example.jsondata.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jsondata.instance.RetrofitInstance
import com.example.jsondata.model.users.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersFragmentModelClass : ViewModel() {
    val mutableLiveData: MutableLiveData<Users> = MutableLiveData()
    fun getLiveDataObserver(): MutableLiveData<Users> {
        return mutableLiveData
    }
    fun apiCallGetUsers() {
        RetrofitInstance.getInstance().getUsers().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                mutableLiveData.postValue(null)
            }

        })

    }
}