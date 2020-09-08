package com.example.dagger2.ui.auth

import androidx.lifecycle.ViewModel
import com.example.dagger2.network.auth.AuthApi
import javax.inject.Inject

class AuthViewModel @Inject constructor(

    authApi: AuthApi
) : ViewModel() {
    init {

        if (authApi == null) {

            println("debug : auth api is null")
        } else {

            println("debig : auth api is not null")
        }
    }


}