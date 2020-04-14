package com.example.homeworkbookapi.di.components

import com.example.homeworkbookapi.api.Interactor
import com.example.homeworkbookapi.di.modules.InteractorModule
import com.example.homeworkbookapi.di.scopes.InteractorScope
import dagger.Subcomponent

@Subcomponent(modules = [InteractorModule::class])
@InteractorScope
interface InteractorComponent {
    fun getInteractor(): Interactor

    @Subcomponent.Builder
    interface Builder{
        fun interactorModule(interactorModule: InteractorModule): Builder
        fun build(): InteractorComponent
    }
}