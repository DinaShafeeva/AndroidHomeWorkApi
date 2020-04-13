package com.example.homeworkbookapi.di.components

import com.example.homeworkbookapi.di.scopes.NetScope
import com.example.homeworkbookapi.di.modules.NetModule
import dagger.Subcomponent
import retrofit2.Retrofit


@Subcomponent(modules = [NetModule::class])
@NetScope
interface NetComponent {
    fun getRetrofit(): Retrofit

    @Subcomponent.Builder
    interface Builder{
        fun netModule(netModule: NetModule): Builder
        fun build(): NetComponent
    }
}