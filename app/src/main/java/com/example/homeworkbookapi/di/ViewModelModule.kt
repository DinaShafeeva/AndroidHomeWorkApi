package com.example.homeworkbookapi.di

import androidx.lifecycle.ViewModel
import com.example.homeworkbookapi.di.scopes.NetScope
import com.example.homeworkbookapi.viewModels.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule  {

    @IntoMap
    @Provides
    @NetScope
    @ViewModelKey(MainViewModel::class)
    fun bindComicsViewModel(
        mainViewModel: MainViewModel
    ): ViewModel = mainViewModel
}
