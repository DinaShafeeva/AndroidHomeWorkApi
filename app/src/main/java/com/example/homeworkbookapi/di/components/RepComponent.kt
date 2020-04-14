package com.example.homeworkbookapi.di.components

import com.example.homeworkbookapi.api.Repository
import com.example.homeworkbookapi.di.modules.RepModule
import com.example.homeworkbookapi.di.scopes.RepScope
import dagger.Subcomponent

@Subcomponent(modules = [RepModule::class])
@RepScope
interface RepComponent {
    fun getRepository(): Repository

    @Subcomponent.Builder
    interface Builder{
        fun repModule(repModule: RepModule): Builder
        fun build(): RepComponent
    }
}