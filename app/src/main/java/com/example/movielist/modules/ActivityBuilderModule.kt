package com.example.movielist.modules

import com.example.movielist.ui.MainActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = [AndroidInjectionModule::class])
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainViewModelModule::class, ShowsRepositoryModule::class])
    abstract fun provideMainActivity(): MainActivity
}