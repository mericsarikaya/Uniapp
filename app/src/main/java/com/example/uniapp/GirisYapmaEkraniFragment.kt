package com.example.uniapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.uniapp.Data.KisiTablosu.KisiTablo
import com.example.uniapp.Data.KisiTablosu.KisiViewModel
import com.example.uniapp.databinding.FragmentGirisYapmaEkraniBinding

class GirisYapmaEkraniFragment : Fragment() {
    private lateinit var binding: FragmentGirisYapmaEkraniBinding
    private lateinit var mkisiviewmodel: KisiViewModel
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGirisYapmaEkraniBinding.inflate(inflater, container, false)
        mkisiviewmodel = ViewModelProvider(this).get(KisiViewModel::class.java)

            binding.bilgiKaydet.setOnClickListener {
                veritabaninaKaydet()
            }
        return binding.root
    }

    private fun veritabaninaKaydet(){
        val isim = binding.isimGirdi.text.toString()
        val soyisim = binding.soyisimGirdi.text.toString()
        val mail = binding.mailGirdi.text.toString()
        val telefon = binding.telefonGirdi.text.toString()
        val dogum = binding.dogumGirdi.text.toString()
        val okul = binding.okulGirdi.text.toString()
        val bolum = binding.bolumGirdi.text.toString()

        if (bosKontrol(isim,soyisim,mail,telefon,dogum,okul,bolum)){
            val kullanici = KisiTablo(0, isim, soyisim, mail, telefon, dogum)
            mkisiviewmodel.kisiEkle(kullanici)
            Toast.makeText(requireContext(), "Başarıyla Eklendi!", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(requireContext(), "Lütfen boş alanları doldurunuz!", Toast.LENGTH_LONG).show()
        }
    }

    private fun bosKontrol(isim: String, soyisim: String, mail:String, telefon: String, dogum: String, okul: String, bolum: String): Boolean{
        return !(TextUtils.isEmpty(isim)&&
               TextUtils.isEmpty(soyisim)&&
               TextUtils.isEmpty(mail)&&
               TextUtils.isEmpty(telefon)&&
               TextUtils.isEmpty(dogum)&&
               TextUtils.isEmpty(okul)&&
               TextUtils.isEmpty(bolum))
    }
}