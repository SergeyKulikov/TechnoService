package ru.great_systems.techoservice.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.great_systems.techoservice.databinding.FragmentProjectInfoBinding
import ru.great_systems.techoservice.domain.ProjectItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PROJECT = "PROJECT"

/**
 * A simple [Fragment] subclass.
 * Use the [ProjectInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProjectInfoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var project: ProjectItem? = null
    private lateinit var binding: FragmentProjectInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            project = it.getSerializable("PROJECT") as ProjectItem
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProjectInfoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment ProjectInfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: ProjectItem) =
            ProjectInfoFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PROJECT, param1)
                }
            }
    }

    private fun setUpView() {
        binding.tvName.text = project!!.subject
        binding.tvDateStart.text = project!!.startDate
        binding.tvDateFinish.text = project!!.endDate
        binding.tvAuthor.text = project!!.createdBy
        binding.tvDescription.text = project!!.description
    }


}