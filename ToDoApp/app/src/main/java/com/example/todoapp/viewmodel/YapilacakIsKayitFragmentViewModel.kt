package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.todoapp.repo.YapilacaklarDaoRepository

class YapilacakIsKayitFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val yrepo = YapilacaklarDaoRepository(application)

    fun kayit(yapilacak_is:String){
        yrepo.yapilacakKayit(yapilacak_is)
    }
}