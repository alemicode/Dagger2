package com.example.dagger2.ui.auth

import androidx.lifecycle.*
import com.example.dagger2.SessionManager
import com.example.dagger2.model.UserDTO
import com.example.dagger2.network.auth.AuthApi

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class AuthViewModel @Inject constructor(

    _sessionManager: SessionManager,
    _authApi1: AuthApi
) : ViewModel() {


    val sessionManager = _sessionManager
    val authApi = _authApi1

    private val data =
        MediatorLiveData<UserDTO>()


    val authUser: LiveData<UserDTO>
        get() = data


    fun authWithId(id: Int) {

        val x  = queryUserId(id)
        //queryUserId(id)?.let { sessionManager.authWithId(it) }
    }

    fun queryUserId(id: Int): LiveData<UserDTO>? {

        val source1 = authApi.getUser(id)

        var result: UserDTO? = null

        source1.toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                it.let {

                    sessionManager.authWithId(it)
                }


            }, { t: Throwable? ->

                Exception("error : ${t?.message}")
            })

        return null
    }





}
