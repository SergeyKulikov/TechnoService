package ru.great_systems.techoservice.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.great_systems.techoservice.databinding.FragmentDashboardBinding
import ru.great_systems.techoservice.domain.ProjectItem
import ru.great_systems.techoservice.domain.ProjectList
import ru.great_systems.techoservice.ui.adapter.ProjectListAdapter

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapter: ProjectListAdapter
    private lateinit var ctx: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

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

        adapter = ProjectListAdapter(ctx, getProjects()) {
        }

        binding.rvProjects.layoutManager = layoutManager
        binding.rvProjects.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(
            binding.rvProjects.context,
            RecyclerView.VERTICAL
        )
        binding.rvProjects.addItemDecoration(dividerItemDecoration)

    }

    private fun getProjects(): MutableList<ProjectItem> {
        val list: MutableList<ProjectItem> = arrayListOf();
        var mBundle: Bundle? = Bundle()
        mBundle = arguments

        if (mBundle != null) {
            if (mBundle.containsKey("PROJECT_LIST")) {
                val proj: ProjectList = mBundle.getSerializable("PROJECT_LIST") as ProjectList

                list.addAll(proj.Projects)
            }
        }
        return list
    }

}