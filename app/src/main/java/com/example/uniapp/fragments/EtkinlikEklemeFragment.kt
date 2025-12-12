package com.example.uniapp.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.uniapp.data.etkinlik.EtkinlikViewModel
import com.example.uniapp.data.etkinlik.etkinlik
import com.example.uniapp.databinding.FragmentEtkinlikEklemeBinding


class EtkinlikEklemeFragment : Fragment() {
    private lateinit var binding: FragmentEtkinlikEklemeBinding
    private lateinit var resimsecme: ActivityResultLauncher<String>
    private lateinit var metkinlikviewmodel: EtkinlikViewModel
    private var secilenfoto: ByteArray? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEtkinlikEklemeBinding.inflate(inflater, container, false)
        metkinlikviewmodel = ViewModelProvider(this).get(EtkinlikViewModel::class.java)
        resimsecme = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            if (uri != null) {
                secilenfoto = uriToByteArray(uri)
            }
        }
        binding.fotoEkle.setOnClickListener {
            resimsecme.launch("image/*")
        }
        binding.kaydet.setOnClickListener { view->
            veritabaninaKaydet(view)
        }
        return binding.root

    }
    private fun uriToByteArray(uri: Uri): ByteArray {
        val inputStream = requireContext().contentResolver.openInputStream(uri)
        return inputStream?.readBytes() ?: ByteArray(0)
    }
    private fun veritabaninaKaydet(view: View){
        val etkinlikad = binding.ad.text.toString()
        val sehir = binding.sehir.text.toString()
        val mekan = binding.mekan.text.toString()
        val zaman = binding.zaman.text.toString()
        val kontenjan = binding.kontenjan.text.toString().toIntOrNull() ?: 0
        val aciklama = binding.aciklama.text.toString()
        val fiyat = binding.fiyat.text.toString().toIntOrNull() ?: 0
        val fotograf = secilenfoto
        val iletisim = binding.klup.text.toString()


        val etkinlik = etkinlik(0,etkinlikad,sehir,mekan,zaman, kontenjan,aciklama, fiyat,fotograf, iletisim)
        metkinlikviewmodel.etkinlikEkle(etkinlik)
    }

}
