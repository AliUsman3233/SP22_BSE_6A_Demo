package com.example.sp22_bse_6a_demo.navigation_practice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.databinding.FragmentABinding
import com.example.sp22_bse_6a_demo.util.SharedPreferenceHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentA : Fragment() {

    lateinit var binding: FragmentABinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()

        binding.userNameTV.setText("Welcome \n ${SharedPreferenceHelper.getUserName(requireContext())}")

    }

    private fun bindUI() {
        binding.firstButtonName = "Save"
        binding.secondButtonName = "${this@FragmentA.javaClass.simpleName} to Fragment C"
        binding.firstNextBtn.setOnClickListener {
            SharedPreferenceHelper.saveUserName(requireContext(), binding.userName.text.toString())
            findNavController().navigate(FragmentADirections.actionFragmentAToFragmentB())
        }
        binding.secondNextBtn.setOnClickListener {
            findNavController().navigate(FragmentADirections.actionFragmentAToFragmentC())
        }
    }

}

