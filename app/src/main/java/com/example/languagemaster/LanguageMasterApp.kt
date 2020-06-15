package com.example.languagemaster

import android.app.Application
import com.example.languagemaster.di.components.AppComponent
import com.example.languagemaster.di.components.DaggerAppComponent

open class LanguageMasterApp : Application() {

    open val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }

    fun component(): AppComponent = component

    init {
        application = this
    }

    companion object {

        @Suppress("unused")
        private val TAG = LanguageMasterApp::class.java.simpleName

        lateinit var application: LanguageMasterApp
            private set
    }
}
