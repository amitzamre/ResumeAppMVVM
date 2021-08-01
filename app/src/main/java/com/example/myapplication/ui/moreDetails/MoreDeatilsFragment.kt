package com.example.myapplication.ui.moreDetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentMoredetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreDeatilsFragment : Fragment() {

    private lateinit var moreDetailsViewModel: MoreDetailsViewModel
    private var _binding: FragmentMoredetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        moreDetailsViewModel =
            ViewModelProvider(this).get(MoreDetailsViewModel::class.java)

        _binding = FragmentMoredetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        moreDetailsViewModel.getMoreDetailsResponse()
        moreDetailsViewModel.moreDetailsResponse.observe(viewLifecycleOwner){
               Log.d("MORE_DETAILS","MORE DETAILS RESPONSE ${it.peekContent().data?.certification}")
                binding.certification.text=it.peekContent().data?.certification
                binding.addLink.text=it.peekContent().data?.addtionalLinks
                binding.recomandtion.text=it.peekContent().data?.recommendation
                binding.email.text=it.peekContent().data?.email
                binding.mobilenum.text=it.peekContent().data?.mobile
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}