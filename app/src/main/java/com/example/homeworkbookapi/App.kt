package com.example.homeworkbookapi

import android.app.Application
import com.example.homeworkbookapi.di.components.AppComponent
import com.example.homeworkbookapi.di.components.DaggerAppComponent
import com.example.homeworkbookapi.di.components.NetComponent
import com.example.homeworkbookapi.di.components.ServiceComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate();
        init(this)
    }
    fun init(app: App) {
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }

    companion object {

        lateinit var appComponent: AppComponent
        lateinit var netComponent: NetComponent
        lateinit var serviceComponent: ServiceComponent
    }

}