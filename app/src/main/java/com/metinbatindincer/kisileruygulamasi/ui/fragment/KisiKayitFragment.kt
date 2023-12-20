package com.metinbatindincer.kisileruygulamasi.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.metinbatindincer.kisileruygulamasi.R
import com.metinbatindincer.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.metinbatindincer.kisileruygulamasi.databinding.FragmentKisiKayitBinding
import com.metinbatindincer.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment() {
    private var _binding: FragmentKisiKayitBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: KisiKayitViewModel
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit, container, false)
        val view = binding.root

        binding.kisiKayitFragment=this
        binding.kisiKayitToolbarBalik="Kişi Kayıt"


        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KisiKayitViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun buttonKaydet(kisi_ad:String,kisi_tel:String){
        viewModel.kaydet(kisi_ad,kisi_tel)
    }

}