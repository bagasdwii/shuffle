package com.cermat.shuffle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.cermat.shuffle.databinding.FragmentHasilnamaBinding
import java.util.*

class HasilnamaFragment : Fragment() {

    val random = Random()
    lateinit var hasilAcakanNama: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val reqnm = HasilnamaFragmentArgs.fromBundle(requireArguments())

        val binding = DataBindingUtil.inflate<FragmentHasilnamaBinding>(
            inflater,
            R.layout.fragment_hasilnama, container, false
        )
        var listnama = reqnm.hslargnm.split(",").toMutableList()
        programAcakNama(listnama)
        binding.hasilnama.text = hasilnm()

        binding.yesnm.setOnClickListener { programAcakNama(listnama)
            binding.hasilnama.text = hasilnm()
        }
        binding.nonm.setOnClickListener { view: View ->
            activity?.finish()
        }
        return binding.root
    }
    fun programAcakNama(listnama: MutableList<String>) {

        if (listnama.isEmpty()){
            Toast.makeText(
                requireContext(),
                "Semua nama sudah diacak",
                Toast.LENGTH_SHORT
            ).show()
        }else{
            val randomNama = random.nextInt(listnama.size)
            val namaTerpilih = listnama[randomNama]
            listnama.removeAt(randomNama)
            hasilAcakanNama = namaTerpilih
        }
    }
    fun hasilnm(): String {
        return hasilAcakanNama
    }
}
