package com.example.uniapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.uniapp.data.kisi.KisiTablosu
import com.example.uniapp.data.kisiTablosu.KisiViewModel
import com.example.uniapp.databinding.FragmentKaydolmaEkraniBinding
import com.example.uniapp.R

class KaydolmaEkraniFragment : Fragment() {
    private lateinit var binding: FragmentKaydolmaEkraniBinding
    private lateinit var mkisiviewmodel: KisiViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKaydolmaEkraniBinding.inflate(inflater,container, false)
        mkisiviewmodel = ViewModelProvider(this).get(KisiViewModel::class.java)
        binding.bilgiKaydet.setOnClickListener {view ->
            veritabaninaKaydet(view)
        }
        return binding.root
    }

    private fun veritabaninaKaydet(view: View){
        val isim = binding.isimGirdi.text.toString()
        val soyisim = binding.soyisimGirdi.text.toString()
        val mail = binding.mailGirdi.text.toString()
        val telefon = binding.telefonGirdi.text.toString()
        val dogum = binding.dogumGirdi.text.toString()
        val okul = binding.okulGirdi.text.toString()
        val bolum = binding.bolumGirdi.text.toString()
        val sifre = binding.sifreGirdi.text.toString()


        if (bosKontrol(isim,soyisim,mail,telefon,dogum,okul,bolum,sifre)){
            val kullanici = KisiTablosu(0, isim, soyisim, mail, telefon, dogum,sifre)
            mkisiviewmodel.kisiEkle(kullanici)
            Toast.makeText(requireContext(), "Başarıyla Eklendi!", Toast.LENGTH_LONG).show()
            Navigation.findNavController(view).navigate(R.id.giris_geri_gecis)
        }
        else{
            Toast.makeText(requireContext(), "Lütfen boş alanları doldurunuz!", Toast.LENGTH_LONG).show()
        }
    }

    private fun bosKontrol(isim: String, soyisim: String, mail:String, telefon: String, dogum: String, okul: String, bolum: String, sifre: String): Boolean{
                return isim.isNotEmpty() &&
                        soyisim.isNotEmpty() &&
                        mail.isNotEmpty() &&
                        telefon.isNotEmpty() &&
                        dogum.isNotEmpty() &&
                        okul.isNotEmpty() &&
                        bolum.isNotEmpty() &&
                        sifre.isNotEmpty()
    }

}