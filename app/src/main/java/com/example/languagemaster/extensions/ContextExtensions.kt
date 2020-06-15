package com.example.languagemaster.extensions

import android.content.Context
import com.example.languagemaster.LanguageMasterApp
import com.example.languagemaster.di.components.AppComponent

val Context.component: AppComponent
    get() = (applicationContext as LanguageMasterApp).component()