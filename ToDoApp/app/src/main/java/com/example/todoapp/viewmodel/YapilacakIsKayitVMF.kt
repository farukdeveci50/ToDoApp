package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class YapilacakIsKayitVMF(var application: Application) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return YapilacakIsKayitFragmentViewModel(application) as T
    }
}