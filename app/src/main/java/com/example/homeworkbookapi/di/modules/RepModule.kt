package com.example.homeworkbookapi.di.modules

import com.example.homeworkbookapi.App
import com.example.homeworkbookapi.api.Repository
import com.example.homeworkbookapi.di.scopes.RepScope
import dagger.Module
import dagger.Provides

@Module
class RepModule {

    @Provides
    @RepScope
    fun bindRepository(): Repository = Repository()
}