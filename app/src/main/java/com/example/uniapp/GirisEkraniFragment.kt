package com.example.uniapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.uniapp.databinding.FragmentGirisEkraniBinding

class GirisEkraniFragment : Fragment() {
    private lateinit var binding: FragmentGirisEkraniBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGirisEkraniBinding.inflate(inflater, container, false)
        binding.girisEkraniResim.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.giris_yapma_gecis)
        }
        return binding.root
    }
}