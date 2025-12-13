package com.example.uniapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.uniapp.data.kisiTablosu.KisiViewModel
import com.example.uniapp.databinding.FragmentSifremiUnuttumBinding
import kotlinx.coroutines.launch
import java.util.Properties
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class SifremiUnuttumFragment : Fragment() {

    private lateinit var binding: FragmentSifremiUnuttumBinding
    private lateinit var mKisiViewModel: KisiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSifremiUnuttumBinding.inflate(inflater, container, false)
        mKisiViewModel = ViewModelProvider(this).get(KisiViewModel::class.java)

        binding.sifreGonderButton.setOnClickListener {
            val mail = binding.sifremiUnuttumMail.text.toString()
            if (mail.isNotEmpty()) {
                lifecycleScope.launch {
                    val kisi = mKisiViewModel.sifreKontrol(mail)
                    if (kisi != null) {
                        val yeniSifre = (100000..999999).random().toString()
                        kisi.sifre = yeniSifre
                        mKisiViewModel.kisiGuncelle(kisi) // ViewModel'de bu fonksiyonu ekleyeceğiz

                        // E-posta gönderme işlemini ayrı bir thread'de yap
                        Thread {
                            try {
                                sendEmail(mail, yeniSifre)
                                activity?.runOnUiThread {
                                    Toast.makeText(requireContext(), "Yeni şifreniz e-posta adresinize gönderildi.", Toast.LENGTH_LONG).show()
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                                activity?.runOnUiThread {
                                    Toast.makeText(requireContext(), "E-posta gönderilemedi.", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }.start()
                    } else {
                        Toast.makeText(requireContext(), "Bu e-posta adresine sahip bir kullanıcı bulunamadı.", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Lütfen e-posta adresinizi girin.", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun sendEmail(recipient: String, yeniSifre: String) {
        val properties = Properties().apply {
            put("mail.smtp.auth", "true")
            put("mail.smtp.starttls.enable", "true")
            put("mail.smtp.host", "smtp.gmail.com")
            put("mail.smtp.port", "587")
        }

        val session = Session.getInstance(properties, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication("uniappdestek@gmail.com", "uniapp123.") // E-posta ve şifrenizi buraya girin
            }
        })

        val message = MimeMessage(session).apply {
            setFrom(InternetAddress("uniappdestek@gmail.com"))
            addRecipient(Message.RecipientType.TO, InternetAddress(recipient))
            subject = "UniApp Şifre Sıfırlama"
            setText("Merhaba, yeni şifreniz: $yeniSifre")
        }

        Transport.send(message)
    }
}
