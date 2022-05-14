package com.example.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentYapilacakIsDetayBinding
import com.example.todoapp.viewmodel.YapilacakIsDetayFragmentViewModel
import com.example.todoapp.viewmodel.YapilacakIsDetayVMF

class YapilacakIsDetayFragment : Fragment() {
    private lateinit var tasarim:FragmentYapilacakIsDetayBinding
    private lateinit var viewModel:YapilacakIsDetayFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacak_is_detay, container, false)
        tasarim.yapilacakIsDetayFragment = this
        tasarim.yapilacakIsDetayToolbarBaslik= "Yapılacak İş Detay"

        val bundle:YapilacakIsDetayFragmentArgs by navArgs()
        val gelenYapilacak = bundle.yapilacak

        tasarim.yapilacakNesnesi = gelenYapilacak



        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:YapilacakIsDetayFragmentViewModel by viewModels(){
            YapilacakIsDetayVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonGuncelle(yapilacak_id:Int,yapilacak_is:String){
        viewModel.guncelle(yapilacak_id,yapilacak_is)

    }


}