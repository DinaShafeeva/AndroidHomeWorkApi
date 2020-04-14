package com.example.homeworkbookapi.di.modules

import com.example.homeworkbookapi.api.Interactor
import com.example.homeworkbookapi.di.scopes.InteractorScope
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    @InteractorScope
    fun bindInteractor(): Interactor = Interactor()
}