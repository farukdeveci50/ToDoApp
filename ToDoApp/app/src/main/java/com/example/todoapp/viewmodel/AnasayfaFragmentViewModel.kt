package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.entity.Yapilacaklar
import com.example.todoapp.repo.YapilacaklarDaoRepository

class AnasayfaFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val yrepo = YapilacaklarDaoRepository(application)
    var yapilacaklarListesi = MutableLiveData<List<Yapilacaklar>>()

    init {
        yapilacaklariYukle()
        yapilacaklarListesi = yrepo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi:String){
        yrepo.yapilacakAra(aramaKelimesi)
    }

    fun sil(yapilacak_id:Int){
        yrepo.yapilacakSil(yapilacak_id)
    }

    fun yapilacaklariYukle(){
        yrepo.tumYapilacaklariAl()
    }
}