package com.example.uniapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.uniapp.Data.KisiTablosu.KisiViewModel
import com.example.uniapp.R
import com.example.uniapp.databinding.FragmentGirisYapmaEkraniBinding
import kotlinx.coroutines.launch

class GirisYapmaEkraniFragment : Fragment() {
    private lateinit var binding: FragmentGirisYapmaEkraniBinding
    private lateinit var mKisiViewModel: KisiViewModel
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGirisYapmaEkraniBinding.inflate(inflater, container, false)
            mKisiViewModel = ViewModelProvider(this).get(KisiViewModel::class.java)

            binding.girisKontrol.setOnClickListener {view ->
                girisKontrol(view)
            }
            binding.kaydol.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.kaydolma_gecis)
            }


        return binding.root
    }

    private fun girisKontrol(view: View){
        val mail = binding.girisMail.text.toString()
        val sifre = binding.girisSifre.text.toString()

        if(mail.isEmpty() || sifre.isEmpty()){
            Toast.makeText(requireContext(), "Lütfen boş bırakılan alanları doldurun!", Toast.LENGTH_SHORT).show()

        }
        else{
            lifecycleScope.launch {
                val kisi = mKisiViewModel.sifrekontrol(mail)

                if (kisi == null){
                    Toast.makeText(requireContext(), "Kullanıcı bulunamadı lütfen kayıt olun!", Toast.LENGTH_SHORT).show()
                }
                else{
                    if (kisi.sifre == sifre){
                        Toast.makeText(requireContext(), "Giriş Başarılı!", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(view).navigate(R.id.anasayfa_gecis)
                    }
                    else{
                        Toast.makeText(requireContext(), "Şifre hatalı. Lütfen tekrar deneyin!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

}