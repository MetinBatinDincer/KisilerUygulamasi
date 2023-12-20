package com.metinbatindincer.kisileruygulamasi.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.metinbatindincer.kisileruygulamasi.R
import com.metinbatindincer.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.metinbatindincer.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.metinbatindincer.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel
import com.metinbatindincer.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment() {
    private var _binding: FragmentKisiDetayBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: KisiDetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay, container, false)
        val view = binding.root

        binding.kisiDetayFragment=this
        binding.kisiDetayToolbarBalik="Kişi Detay"
        val bundle:KisiDetayFragmentArgs by navArgs()
        val gelenKisi=bundle.kisi

        binding.kisiNesnesi=gelenKisi

        binding.editTextKisiAd.setText(gelenKisi.kisi_ad)
        binding.EditTextKisiTel.setText(gelenKisi.kisi_tel)




        binding.buttonAra.setOnClickListener {

            val phoneNumber = binding.EditTextKisiTel.text.toString().trim()

            // Telefon numarası boş değilse ve numara uzunluğu 0'dan büyükse arama yap
            if (phoneNumber.isNotEmpty() && phoneNumber.length > 0) {
                // Intent'i oluştur
                val intent = Intent(Intent.ACTION_CALL)

                // Telefon numarasını intent'e ekle
                intent.data = Uri.parse("tel:$phoneNumber")

                // Aramayı başlat
                startActivity(intent)
            }
        }

        return view





    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiDetayViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun buttonGuncelle(kisi_id:String,kisi_ad:String,kisi_tel:String){
        viewModel.guncelle(kisi_id,kisi_ad,kisi_tel)
    }


}