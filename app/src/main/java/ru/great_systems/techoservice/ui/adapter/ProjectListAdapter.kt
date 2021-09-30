package ru.great_systems.techoservice.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.great_systems.techoservice.R
import ru.great_systems.techoservice.domain.ProjectItem
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

class ProjectListAdapter(
    context: Context,
    private var items: List<ProjectItem>,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<ProjectListViewHolder>() {

    private var mInflater: LayoutInflater = LayoutInflater.from(context)

    init {
    }

    private val fullDateFormat: SimpleDateFormat =
        SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

    private val calendar: Calendar = Calendar.getInstance(Locale.getDefault())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectListViewHolder {
        val view: View = mInflater.inflate(R.layout.layout_project_item, parent, false)

        val holder = ProjectListViewHolder(view)
        holder.itemView.setOnClickListener { listener.invoke(holder.adapterPosition) }

        return ProjectListViewHolder(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ProjectListViewHolder, position: Int) {
        val project = items[position]

        holder.tvName.text = project.subject;
        holder.tvPeriod.text = project.endDate + " - " +project.finishDate
        holder.tvAuthor.text = project.createdBy
    }

    private fun longToDateString(time: Long?): String {
        if (time == null) return ""
        return fullDateFormat.format(Date(time))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private fun getLongByDateString(dateString: String): Long {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val date: LocalDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"))

            date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()
        } else {
            val calendar: Calendar = Calendar.getInstance()
            val parser = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            calendar.time = parser.parse(dateString)

            calendar.timeInMillis
        }
    }
}