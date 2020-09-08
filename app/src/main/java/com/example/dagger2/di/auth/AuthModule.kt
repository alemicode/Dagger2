package com.example.dagger2.di.auth

import com.example.dagger2.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class AuthModule {


    companion object {

        @Provides
        fun getAuthApi(retrofit: Retrofit): AuthApi {

            return retrofit.create(AuthApi::class.java)

        }

    }

}