package ru.great_systems.techoservice.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils.getActivity
import ru.great_systems.techoservice.R
import ru.great_systems.techoservice.domain.ProjectItem
import java.util.*

class ProjectListAdapter(
    context: Context,
    private var items: List<ProjectItem>,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<ProjectListViewHolder>() {

    private var mInflater: LayoutInflater = LayoutInflater.from(context)

    init {
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectListViewHolder {
        val view: View = mInflater.inflate(R.layout.layout_project_item, parent, false)

         return ProjectListViewHolder(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ProjectListViewHolder, position: Int) {
        val project = items[position]

        holder.tvName.text = project.subject;
        holder.tvPeriod.text = project.startDate + " - " + project.endDate
        holder.tvAuthor.text = project.createdBy



        holder.itemView.setOnClickListener {
            val args = Bundle()
            args.putSerializable("PROJECT", project)

            // listener.invoke(holder.adapterPosition)
            findNavController(it).navigate(
                R.id.action_navigation_dashboard_to_projectInfoFragment, args)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }


}