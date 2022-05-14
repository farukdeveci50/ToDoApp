package com.example.todoapp.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.entity.Yapilacaklar
import com.example.todoapp.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarDaoRepository(var application: Application) {
    var yapilacaklarListesi:MutableLiveData<List<Yapilacaklar>>
    var vt:Veritabani

    init {
        yapilacaklarListesi = MutableLiveData()
        vt = Veritabani.veritabaniErisim(application)!!
    }

    fun yapilacaklariGetir() : MutableLiveData<List<Yapilacaklar>>{
        return yapilacaklarListesi
    }

    fun yapilacakKayit(yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniYapilacaklar = Yapilacaklar(0,yapilacak_is)
            vt.yapilacaklarDao().yapilacakEkle(yeniYapilacaklar)
        }
    }

    fun yapilacakGuncelle(yapilacak_id:Int,yapilacak_is: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenYapilacak = Yapilacaklar(yapilacak_id,yapilacak_is)
            vt.yapilacaklarDao().yapilacakGuncelle(guncellenenYapilacak)
        }
    }

    fun yapilacakAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = vt.yapilacaklarDao().yapilacakArama(aramaKelimesi)
        }
    }

    fun yapilacakSil(yapilacak_id: Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenYapilacak = Yapilacaklar(yapilacak_id,"")
            vt.yapilacaklarDao().yapilacakSil(silinenYapilacak)
            tumYapilacaklariAl()
        }
    }

    fun tumYapilacaklariAl(){
       val job = CoroutineScope(Dispatchers.Main).launch {
           yapilacaklarListesi.value = vt.yapilacaklarDao().tumYapilacaklar()
       }
    }

}