package com.example.sp22_bse_6a_demo.navigation_practice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.databinding.FragmentABinding
import com.example.sp22_bse_6a_demo.databinding.FragmentCBinding


class FragmentC : Fragment() {

    lateinit var binding: FragmentCBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCBinding.inflate(inflater,container,false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
    }

    private fun bindUI() {
        binding.buttonName = "${this@FragmentC.javaClass.simpleName} to Final Fragment"
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(FragmentCDirections.actionFragmentCToFinalFragment())
        }
    }

}