package com.example.dagger2.di

import android.app.Application
import com.example.dagger2.BaseApplication
import com.example.dagger2.SessionManager
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class]

)

interface AppComponent : AndroidInjector<BaseApplication> {

    val sessionManager : SessionManager
        get() = SessionManager()

    @Component.Builder
    interface Builder {


        @BindsInstance
        fun Application(application: Application): Builder


        fun build(): AppComponent
    }

}