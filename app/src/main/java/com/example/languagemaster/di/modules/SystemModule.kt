package com.example.languagemaster.di.modules

import android.app.Application
import com.example.languagemaster.LanguageMasterApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SystemModule {

    @Provides
    @Singleton
    internal fun provideApplication(): Application = LanguageMasterApp.application
}