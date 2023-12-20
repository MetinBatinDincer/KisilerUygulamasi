package com.metinbatindincer.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.R
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.metinbatindincer.kisileruygulamasi.data.entity.Kisiler
import com.metinbatindincer.kisileruygulamasi.databinding.CardTasarimBinding
import com.metinbatindincer.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.metinbatindincer.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.metinbatindincer.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.metinbatindincer.kisileruygulamasi.util.gecisYap

class KisilerAdapter(var mContex:Context,var kisilerListesi:List<Kisiler>,var viewModel:AnasayfaViewModel) : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val _binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContex),com.metinbatindincer.kisileruygulamasi.R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(_binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val kisi = kisilerListesi.get(position)
        val t=holder.tasarim

        t.kisiNesnesi=kisi
        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToKisiDetayFragment(kisi=kisi)


            Navigation.gecisYap(it, gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(kisi.kisi_id!!)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }



}