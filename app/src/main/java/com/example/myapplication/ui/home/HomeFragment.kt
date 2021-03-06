package com.example.myapplication.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
          ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeViewModel.getHomeReposne()


        Log.d("Resposne for home", "home resposne: ${homeViewModel.getHomeReposne().toString()}")
        homeViewModel.homeResponse.observe(viewLifecycleOwner){

                    Log.d("Resposne for home- name", "home resposne: ${it.peekContent().data?.name}")
                    binding.textHome.text = it.peekContent().data?.name
                    binding.textQualification.text=it.peekContent().data?.qulification
                    binding.textSkills.text=it.peekContent().data?.skills




        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}