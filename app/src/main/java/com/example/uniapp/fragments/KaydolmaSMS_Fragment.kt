package com.example.uniapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.uniapp.R
import com.example.uniapp.data.kisi.KisiTablosu
import com.example.uniapp.data.kisiTablosu.KisiViewModel
import com.example.uniapp.databinding.FragmentKaydolmaSMSBinding

class KaydolmaSMS_Fragment : Fragment() {

    private lateinit var binding: FragmentKaydolmaSMSBinding
    private lateinit var mKisiViewModel: KisiViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentKaydolmaSMSBinding.inflate(inflater, container, false)
        mKisiViewModel = ViewModelProvider(this)[KisiViewModel::class.java]

        // Önceki ekrandan gelen verileri al
        val args = arguments
        val isim = args?.getString("isim")!!
        val soyisim = args.getString("soyisim")!!
        val mail = args.getString("mail")!!
        val telefon = args.getString("telefon")!!
        val dogum = args.getString("dogum")!!
        val sifre = args.getString("sifre")!!
        val dogrulamaKodu = args.getString("verificationCode")!!

        binding.KayitKoduOnay.setOnClickListener { view ->
            val girilenKod = binding.kayitkodu.text.toString().trim()

            if (girilenKod.isNotEmpty()) {
                if (girilenKod == dogrulamaKodu) {
                    // Kodlar eşleşti, kullanıcıyı kaydet
                    val yeniKullanici = KisiTablosu(0, isim, soyisim, mail, telefon, dogum, sifre)
                    mKisiViewModel.kisiEkle(yeniKullanici)

                    Toast.makeText(requireContext(), "Kayıt başarıyla tamamlandı!", Toast.LENGTH_LONG).show()

                    // Kayıt başarılı, giriş ekranına yönlendir
                    Navigation.findNavController(view).navigate(R.id.action_kaydolmaSMS_Fragment_to_girisYapmaEkraniFragment)
                } else {
                    // Kodlar eşleşmedi
                    Toast.makeText(requireContext(), "Doğrulama kodu yanlış.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Lütfen doğrulama kodunu giriniz.", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}
