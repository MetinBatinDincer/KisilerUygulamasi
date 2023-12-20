package com.metinbatindincer.kisileruygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.metinbatindincer.kisileruygulamasi.R
import com.metinbatindincer.kisileruygulamasi.data.entity.Kisiler
import com.metinbatindincer.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.metinbatindincer.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.metinbatindincer.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.metinbatindincer.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import com.metinbatindincer.kisileruygulamasi.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private var _binding: FragmentAnasayfaBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        binding.anasayfaFragment=this
        val view = binding.root

        binding.anasayfaToolbarBalik="Kişiler"


        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val kisilerAdapter=KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter=kisilerAdapter
        }











        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(p0: String): Boolean {
                viewModel.ara(p0)
                return true
            }

            override fun onQueryTextSubmit(p0: String): Boolean {
                viewModel.ara(p0)
                return true
            }
        })


        return view
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun fabTikla(it:View){
        Navigation.gecisYap(it,R.id.kisiKayitFragment)
    }



}