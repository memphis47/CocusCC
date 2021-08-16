package com.cocus.cocuscc.di

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.viewModels


inline fun <reified T: ViewModel> FragmentActivity.viewModel(crossinline provider: () -> T) = viewModels<T> {
    object : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>) = provider() as T
    }
}

inline fun <reified T: ViewModel> Fragment.viewModel(crossinline provider: () -> T) = viewModels<T> {
    object : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>) = provider() as T
    }
}

inline fun <reified T: ViewModel> Fragment.activityViewModel(crossinline provider: () -> T) = activityViewModels<T> {
    object : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>) = provider() as T
    }
}