package com.example.homeworkbookapi.di.modules

import com.example.homeworkbookapi.App
import com.example.homeworkbookapi.api.MarvelService
import com.example.homeworkbookapi.di.scopes.ServiceScope
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @Provides
    @ServiceScope
    fun bindMarvelService(): MarvelService = App.netComponent.getRetrofit().create(
        MarvelService::class.java)
}