package ru.great_systems.techoservice.domain

data class ProjectItem(
    val id: String,
    val subject: String,
    val description: String,
    val createdBy: String,
    val endDate: String,
    val finishDate: String,
    val cost: Double
)

