package ru.great_systems.techoservice.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import ru.great_systems.techoservice.databinding.FragmentHomeBinding
import com.google.gson.reflect.TypeToken
import ru.great_systems.techoservice.MainActivity
import ru.great_systems.techoservice.domain.ProjectList


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

        val tvJSON: TextView = binding.tvJSON
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            tvJSON.text = it
        })

        binding.btnSave.setOnClickListener {
            val gson = Gson()
            val arrayProjectType = object : TypeToken<ProjectList>() {}.type
            var projectList: ProjectList? = null
            try {
                projectList = gson.fromJson(tvJSON.text.toString(), arrayProjectType)
            } catch (e: Exception) {
                Snackbar.make(it,"Ошибка чтения JSON файла", Snackbar.LENGTH_LONG).show()
            }

            if (projectList != null) {
                (activity as MainActivity?)!!.changeFolder(projectList)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}