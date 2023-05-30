package com.cermat.shuffle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.cermat.shuffle.databinding.FragmentAngkaBinding



class AngkaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAngkaBinding>(
            inflater,
            R.layout.fragment_angka, container, false
        )

        binding.button.setOnClickListener { view: View ->
            val maxAngka = binding.input.text.toString().trim()
            if (maxAngka.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Masukan max angka",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                view.findNavController()
                    .navigate(
                        AngkaFragmentDirections.actionAngkaFragmentToHasilangkaFragment(
                            maxAngka.toInt()
                        )
                    )
            }
        }
        return binding.root
    }
}