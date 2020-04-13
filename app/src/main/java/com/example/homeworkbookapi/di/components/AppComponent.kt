package com.example.homeworkbookapi.di.components

import com.example.homeworkbookapi.App
import com.example.homeworkbookapi.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
    interface AppComponent {

//    fun getContext(): Context
//    fun inject(mainActivity: MainActivity)
    fun plusNetComponentBuilder(): NetComponent.Builder
    fun plusServiceComponentBuilder(): ServiceComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }

}