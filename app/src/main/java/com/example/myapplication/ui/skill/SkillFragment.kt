package com.example.myapplication.ui.skill

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentSkillBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SkillFragment : Fragment() {

    private lateinit var skillViewModel: SkillViewModel
    private var _binding: FragmentSkillBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        skillViewModel =
            ViewModelProvider(this).get(SkillViewModel::class.java)

        _binding = FragmentSkillBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        skillViewModel.getSkillResponse()
        Log.d("Skill response","${skillViewModel.getSkillResponse().toString()}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}