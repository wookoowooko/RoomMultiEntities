package io.wookoo.roommultientities.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import io.wookoo.roommultientities.entities.Director
import io.wookoo.roommultientities.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director,
)
