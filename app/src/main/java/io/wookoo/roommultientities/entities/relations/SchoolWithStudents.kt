package io.wookoo.roommultientities.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import io.wookoo.roommultientities.entities.School
import io.wookoo.roommultientities.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>,
)
