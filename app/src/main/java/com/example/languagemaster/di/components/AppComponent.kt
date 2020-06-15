package com.example.languagemaster.di.components

import com.example.languagemaster.LanguageMasterApp
import com.example.languagemaster.activities.BaseMvvmActivity
import com.example.languagemaster.di.modules.SystemModule
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        SystemModule::class
    ]
)
@Singleton
interface AppComponent {

    //region Application

    fun inject(languageMasterApp: LanguageMasterApp)
    //endregion

    //region Activities

    fun inject(activity: BaseMvvmActivity)
    //endregion
}