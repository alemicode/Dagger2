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


    fun authWithId(source: UserDTO) {
       cacheUser.value = source

    }
}