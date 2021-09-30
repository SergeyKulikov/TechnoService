package ru.great_systems.techoservice.domain

import java.io.Serializable

data class ProjectItem (
    val id: String,
    val subject: String,
    val description: String,
    val createdBy: String,
    val startDate: String,
    val endDate: String,
    val cost: Double
) : Serializable

