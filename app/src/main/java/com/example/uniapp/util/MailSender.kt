package com.example.uniapp.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Properties
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


class MailSender {

   
    private val username = "uniappfms@gmail.com"
    private val password = "mcgseyheglviskqq"

    private val props = Properties().apply {
        put("mail.smtp.auth", "true")
        put("mail.smtp.starttls.enable", "true")
        put("mail.smtp.host", "smtp.gmail.com")
        put("mail.smtp.port", "587")
    }

    private val session = Session.getInstance(props, object : Authenticator() {
        override fun getPasswordAuthentication(): PasswordAuthentication {
            return PasswordAuthentication(username, password)
        }
    })

    suspend fun sendEmail(recipient: String, subject: String, body: String) {
        withContext(Dispatchers.IO) { // Ağ işlemleri arka planda yapılmalıdır
            try {
                val message = MimeMessage(session).apply {
                    setFrom(InternetAddress(username))
                    addRecipient(Message.RecipientType.TO, InternetAddress(recipient))
                    this.subject = subject
                    setText(body)
                }
                Transport.send(message)
                println("E-posta başarıyla gönderildi: $recipient")
            } catch (e: Exception) {
                e.printStackTrace()
                println("E-posta gönderme hatası: ${e.message}")
            }
        }
    }
}
