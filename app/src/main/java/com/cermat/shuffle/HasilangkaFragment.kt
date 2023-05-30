package com.cermat.shuffle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.cermat.shuffle.databinding.FragmentHasilangkaBinding
import java.util.*
import kotlin.collections.ArrayList


class HasilangkaFragment : Fragment() {

    val random = Random()
    var hasilAcakan: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val req = HasilangkaFragmentArgs.fromBundle(requireArguments())

        val binding = DataBindingUtil.inflate<FragmentHasilangkaBinding>(
            inflater,
            R.layout.fragment_hasilangka, container, false
        )
        var max: Int = req.hslarg
        programAcakAngka(max)
        binding.hasil.text = hasilku().toString()

        binding.btnyes.setOnClickListener {
            sisamax()
            binding.hasil.text = hasilku().toString()
        }
        binding.btnno.setOnClickListener { view: View ->
            activity?.finish()
        }
        return binding.root
    }

    val listangka: MutableList<Int> = ArrayList()
    fun programAcakAngka(maxAngka: Int) {

        for (i in 1..maxAngka) {
            listangka.add(i)
        }

        while (listangka.isNotEmpty()) {
            val randomAngka = random.nextInt(listangka.size)
            val angkaTerpilih = listangka[randomAngka]
            listangka.removeAt(randomAngka)

            if (angkaTerpilih != hasilAcakan) {
                hasilAcakan = angkaTerpilih
                break
            }
        }
    }

    fun hasilku(): Int {
        return hasilAcakan
    }

    fun sisamax() {

        if (listangka.isEmpty()) {
            Toast.makeText(
                requireContext(),
                "Semua angka telah diacak",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val randomAngka = random.nextInt(listangka.size)
            val angkaTerpilih = listangka[randomAngka]
            listangka.removeAt(randomAngka)
            angkaTerpilih != hasilAcakan
            hasilAcakan = angkaTerpilih

        }
    }
}
