package com.example.homeworkbookapi.di.components

import com.example.homeworkbookapi.api.MarvelService
import com.example.homeworkbookapi.di.scopes.ServiceScope
import com.example.homeworkbookapi.di.modules.ServiceModule
import dagger.Subcomponent

@Subcomponent(modules = [ServiceModule::class])
@ServiceScope
interface ServiceComponent {
    fun marvelService(): MarvelService

    @Subcomponent.Builder
    interface Builder{
        fun serviceModule(serviceModule: ServiceModule): Builder
        fun build(): ServiceComponent
    }
}