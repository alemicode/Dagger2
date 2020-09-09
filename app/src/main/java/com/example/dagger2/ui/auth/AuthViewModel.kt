package com.example.dagger2.ui.auth

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.dagger2.models.ResponseDTO
import com.example.dagger2.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(

    authApi: AuthApi
) : ViewModel() {
    init {

        //if using rx java
        //observablesUsingRX(authApi)


        //if using liveDaga
        observes(authApi)
    }

    private fun observes(authApi: AuthApi) {

        
    }



    //managing data  using RX
    private fun observablesUsingRX(authApi: AuthApi) {

        authApi.getUser(1)
            .subscribeOn(Schedulers.io())

            .subscribe({ response ->

                println("debug : response is ok ${response.name} ${response.id}")
            }, { t: Throwable? -> }


            )


    }



}

