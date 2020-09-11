package com.example.dagger2.ui.auth

import androidx.lifecycle.*
import com.example.dagger2.model.UserDTO
import com.example.dagger2.network.auth.AuthApi

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(

    authApi1: AuthApi
) : ViewModel() {


    val authApi = authApi1
    private val data =
        MediatorLiveData<UserDTO>()


    val resultLiveData: LiveData<UserDTO>
        get() = data


    fun auth(id: Int) {




        val source1 = authApi.getUser(id)


        source1.toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

              data.postValue(it)

            }, { t: Throwable? ->

                Exception("error : ${t?.message}")
            })


    }


}
