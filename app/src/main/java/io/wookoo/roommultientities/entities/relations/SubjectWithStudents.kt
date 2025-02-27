package io.wookoo.roommultientities.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import io.wookoo.roommultientities.entities.Student
import io.wookoo.roommultientities.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>,
)
