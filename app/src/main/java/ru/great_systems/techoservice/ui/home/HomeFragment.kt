package ru.great_systems.techoservice.ui.home

import android.R.attr
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import ru.great_systems.techoservice.databinding.FragmentHomeBinding
import ru.great_systems.techoservice.domain.ProjectItem
import android.R.attr.data
import org.w3c.dom.NameList


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
            var args = Bundle();
            Log.d("TAG", "Text: "+tvJSON.text);

            // val gson = Gson()
            // val m: MutableList<ProjectItem> = gson.fromJson(tvJSON.text, ProjectItem::class.java)


        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}