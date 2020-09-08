package com.example.dagger2.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.dagger2.R
import com.example.dagger2.util.Constans
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule {

    companion object {


        @Singleton
        @Provides
        fun provideRetrofitInstanse(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(Constans.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


        @Singleton
        @Provides

        fun provideRequestOption(): RequestOptions {
            return RequestOptions.placeholderOf(R.drawable.logo)
                .error(R.drawable.ic_launcher_background)
        }

        @Singleton
        @Provides
        fun provideGlideInstance(
            application: Application,
            requestOptions: RequestOptions
        ): RequestManager {

            return Glide.with(application)
                .setDefaultRequestOptions(requestOptions)
        }

        @Singleton
        @Provides
        fun prvideAppDrawable(application: Application): Drawable {

            return ContextCompat.getDrawable(application, R.drawable.logo)!!
        }
    }
}