package com.example.movielist.di

import com.example.movielist.MoviesApplication
import com.example.movielist.modules.ActivityBuilderModule
import com.example.movielist.modules.DatabaseModule
import com.example.movielist.modules.ViewModelFactoryModule
import com.example.movielist.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ActivityBuilderModule::class,
        DatabaseModule::class]
)
interface AppComponent : AndroidInjector<MoviesApplication> {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: MoviesApplication): Builder
    }
}