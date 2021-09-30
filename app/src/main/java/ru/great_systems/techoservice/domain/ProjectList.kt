package ru.great_systems.techoservice.domain

import java.io.Serializable

class ProjectList : Serializable {
    var Projects: MutableList<ProjectItem> = mutableListOf()
}