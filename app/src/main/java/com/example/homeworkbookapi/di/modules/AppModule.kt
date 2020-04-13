package com.example.homeworkbookapi.di.modules

import android.app.Application
import android.content.Context
import com.example.homeworkbookapi.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun bindContext(application: App): Context = application.applicationContext
}