package ru.great_systems.techoservice.ui.dashboard

import android.content.Context
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
import ru.great_systems.techoservice.R
import ru.great_systems.techoservice.databinding.FragmentDashboardBinding
import ru.great_systems.techoservice.domain.ProjectItem
import ru.great_systems.techoservice.ui.adapter.ProjectListAdapter

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapter: ProjectListAdapter
    private lateinit var context: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        context = view?.context!!

        /*
        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        */

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView();
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpView() {
        val layoutManager = LinearLayoutManager(context)

        val projects: MutableList<ProjectItem> = mutableListOf();



        adapter = ProjectListAdapter(context, projects) {
        }
        // Log.d(TAG,"getCommitmentsAsItemByContract("+contractId+"): "+adapter.getItemCount())

        // adapter.setComplexObligationFilter()

        binding.rvProjects.layoutManager = layoutManager
        binding.rvProjects.adapter = adapter
    }

}