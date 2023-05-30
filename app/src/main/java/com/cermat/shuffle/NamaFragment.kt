package com.cermat.shuffle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.cermat.shuffle.databinding.FragmentNamaBinding
import java.util.ArrayList


class NamaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNamaBinding>(
            inflater,
            R.layout.fragment_nama, container, false
        )

        binding.tambah.setOnClickListener { view: View ->

            val nama = binding.inputnm2.text.toString().trim()

            if (nama.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Masukkan nama",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                val namaList: MutableList<String> = ArrayList()
                namaList.add(nama)
                binding.list.text = namaList.toString()
                view.findNavController()
                    .navigate(
                        NamaFragmentDirections.actionNamaFragmentToHasilnamaFragment(
                            binding.inputnm2.text.toString())
                        )
            }
        }
        return binding.root
    }
}