package com.example.dagger2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.dagger2.model.UserDTO
import javax.inject.Inject
import javax.inject.Singleton
import javax.xml.transform.Source


@Singleton
class SessionManager @Inject constructor(

) {


    val cacheUser: MediatorLiveData<UserDTO> = MediatorLiveData<UserDTO>()

    val authUser: LiveData<UserDTO>
        get() = cacheUser


    fun authWithId(source: MediatorLiveData<UserDTO>) {
        if (cacheUser != null) {
            cacheUser.addSource(source, Observer {
                cacheUser.postValue(it)
            })
        } else {
            println("Authentication : perviuse auth detected from cache")
        }

    }
}