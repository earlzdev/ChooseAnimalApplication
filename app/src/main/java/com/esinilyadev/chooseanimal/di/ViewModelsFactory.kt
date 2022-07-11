package com.esinilyadev.chooseanimal.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esinilyadev.chooseanimal.presentation.MainViewModel

class ViewModelsFactory(private val container: DependencyContainer): ViewModelProvider.Factory {

    private val map = HashMap<Class<*>, Feature>().apply {
        put(MainViewModel::class.java, Feature.CHOOSE_ANIMAL)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val feature = map[modelClass] ?: throw IllegalStateException("viewModel $modelClass not found")
        return container.module(feature).viewModel() as T
    }
}