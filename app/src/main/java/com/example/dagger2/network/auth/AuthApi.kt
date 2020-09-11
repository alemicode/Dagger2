package com.example.dagger2.network.auth

import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.LiveData
import com.example.dagger2.model.UserDTO
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {


    @GET("users/{id}")

    fun getUser(@Path("id") id: Int): Single<UserDTO>

}