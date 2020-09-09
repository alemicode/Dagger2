package com.example.dagger2.network.auth

import com.example.dagger2.models.ResponseDTO
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {


    @GET("users/{id}")

    fun getUser(@Path("id") id: Int): Observable<ResponseDTO>

}