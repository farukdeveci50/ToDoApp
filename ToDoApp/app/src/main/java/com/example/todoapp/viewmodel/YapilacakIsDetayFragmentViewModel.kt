package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.todoapp.repo.YapilacaklarDaoRepository

class YapilacakIsDetayFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val yrepo = YapilacaklarDaoRepository(application)

    fun guncelle(yapilacak_id:Int,yapilacak_is:String){
        yrepo.yapilacakGuncelle(yapilacak_id,yapilacak_is)
    }
}