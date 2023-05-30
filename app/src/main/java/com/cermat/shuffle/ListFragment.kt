package com.cermat.shuffle

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.cermat.shuffle.databinding.FragmentListBinding


class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentListBinding>(inflater,
            R.layout.fragment_list,container,false)
        binding.btnangka.setOnClickListener { view: View ->
            val intent = Intent(activity, MainActivityAngka::class.java)
            startActivity(intent)

        }
        binding.btnnama.setOnClickListener { view: View ->
            val intent = Intent(activity, MainActivityNama::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}