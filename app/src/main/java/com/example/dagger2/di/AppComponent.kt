package com.example.dagger2.di

import android.app.Application
import com.example.dagger2.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule

@Component(

    modules = [AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class]

)

interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {


        @BindsInstance
        fun Application(application: Application): Builder


        fun build(): AppComponent
    }

}