package com.example.myapplication.ui.project

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentProjectBinding
import com.example.myapplication.local.projects.Project
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProjectFragment : Fragment() {

    private lateinit var projectViewModel: ProjectViewModel
    private var _binding: FragmentProjectBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        projectViewModel =
            ViewModelProvider(this).get(ProjectViewModel::class.java)

        _binding = FragmentProjectBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        projectViewModel.getProjectResponse()
        projectViewModel.projectResponse.observe(viewLifecycleOwner){
            val projectList:List<Project> ? =it.peekContent().data?.projects
            Log.d("Project reposne " ,"${projectList}")
            if(null!=projectList){
                Log.d("PROJECT_DEBUG","Inside block - project list not null")
                Log.d("PROJECT_DEBUG","Project list lenght ${projectList.size}")
                binding.projectList.adapter=ProjectDetailsListAdapter(projectList)
                binding.projectList.layoutManager=LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
                binding.projectList.setHasFixedSize(true)
            }else{
                Log.e("NO_Reposne_PROJECT","no response recieved from Project API")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}