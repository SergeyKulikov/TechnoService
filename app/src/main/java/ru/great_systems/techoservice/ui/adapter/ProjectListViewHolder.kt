package ru.great_systems.techoservice.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.great_systems.techoservice.R


class ProjectListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvName: TextView = view.findViewById(R.id.tvName)
    var tvAuthor: TextView = view.findViewById(R.id.tvAuthor)
    var tvPeriod: TextView = view.findViewById(R.id.tvPeriod)
}