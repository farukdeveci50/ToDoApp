package com.example.todoapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.databinding.CardTasarimBinding
import com.example.todoapp.databinding.FragmentAnasayfaBinding
import com.example.todoapp.entity.Yapilacaklar
import com.example.todoapp.fragment.AnasayfaFragmentDirections
import com.example.todoapp.viewmodel.AnasayfaFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(var mContext:Context,
                          var yapilacaklarListesi:List<Yapilacaklar>,
                          var viewModel:AnasayfaFragmentViewModel)
    : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>(){
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:CardTasarimBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacaklar = yapilacaklarListesi.get(position)
        val t = holder.tasarim

        t.yapilacakNesnesi = yapilacaklar

        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it,"${yapilacaklar.yapilacak_is} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.sil(yapilacaklar.yapilacak_id)
                }
                .show()
        }

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.yapilacakIsDetayGecis(yapilacak = yapilacaklar)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }
}