package com.example.uniapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.uniapp.R
import com.example.uniapp.data.kisiTablosu.KisiViewModel // DOĞRU IMPORT
import com.example.uniapp.databinding.FragmentKaydolmaEkraniBinding
import com.example.uniapp.util.MailSender
import kotlinx.coroutines.launch

class KaydolmaEkraniFragment : Fragment() {
    private var _binding: FragmentKaydolmaEkraniBinding? = null
    private val binding get() = _binding!!
    private lateinit var mKisiViewModel: KisiViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentKaydolmaEkraniBinding.inflate(inflater, container, false)
        mKisiViewModel = ViewModelProvider(this)[KisiViewModel::class.java]

        binding.bilgiKaydet.setOnClickListener {
            sendVerificationEmailAndNavigate()
        }

        return binding.root
    }

    private fun sendVerificationEmailAndNavigate() {
        val isim = binding.isimGirdi.text.toString().trim()
        val soyisim = binding.soyisimGirdi.text.toString().trim()
        val mail = binding.mailGirdi.text.toString().trim()
        val telefon = binding.telefonGirdi.text.toString().trim()
        val dogum = binding.dogumGirdi.text.toString().trim()
        val sifre = binding.sifreGirdi.text.toString()

        if (isim.isNotEmpty() && soyisim.isNotEmpty() && mail.isNotEmpty() && telefon.isNotEmpty() && dogum.isNotEmpty() && sifre.isNotEmpty()) {

            val verificationCode = (100000..999999).random().toString()

            lifecycleScope.launch {
                val mailSender = MailSender()
                val subject = "UniApp Doğrulama Kodunuz"
                val body = "Kaydınızı tamamlamak için doğrulama kodunuz: $verificationCode"
                mailSender.sendEmail(mail, subject, body)
            }

            val bundle = bundleOf(
                "isim" to isim,
                "soyisim" to soyisim,
                "mail" to mail,
                "telefon" to telefon,
                "dogum" to dogum,
                "sifre" to sifre,
                "verificationCode" to verificationCode
            )

            Toast.makeText(requireContext(), "Doğrulama kodu e-postanıza gönderildi.", Toast.LENGTH_LONG).show()

            // Navigasyon grafiğine eklediğimiz doğru action ID'si ile güvenli geçiş yapılıyor.
            findNavController().navigate(R.id.action_kaydolmaEkraniFragment_to_kaydolmaSMS_Fragment, bundle)

        } else {
            Toast.makeText(requireContext(), "Lütfen tüm zorunlu alanları doldurunuz!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
