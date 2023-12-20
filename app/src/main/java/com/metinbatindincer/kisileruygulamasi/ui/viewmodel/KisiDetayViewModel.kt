package com.metinbatindincer.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.metinbatindincer.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor(var krepo:KisilerRepository):ViewModel() {


    fun guncelle(kisi_id:String,kisi_ad:String,kisi_tel:String){
        krepo.guncelle(kisi_id,kisi_ad,kisi_tel)
    }

}