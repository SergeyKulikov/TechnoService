package ru.great_systems.techoservice.domain

data class ProjectItem(
    val id: String,
    val subject: String,
    val description: String,
    val createdBy: String,
    val startDate: String,
    val endDate: String,
    val cost: Double
)

