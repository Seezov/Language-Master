package com.example.languagemaster.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.languagemaster.di.ViewModelFactory
import com.example.languagemaster.viewmodels.BaseViewModel
import com.example.languagemaster.extensions.component
import javax.inject.Inject
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class BaseMvvmActivity : AppCompatActivity() {

    protected abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected inline fun <reified T : BaseViewModel> viewModelDelegate() =
        object : ReadOnlyProperty<AppCompatActivity, T> {

            var value: T? = null

            override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
                if (value == null) {
                    value = ViewModelProvider(viewModelStore, viewModelFactory).get(T::class.java)
                }
                return value as T
            }
        }
}