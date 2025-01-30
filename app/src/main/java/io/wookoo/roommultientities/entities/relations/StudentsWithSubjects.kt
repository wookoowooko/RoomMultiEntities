package io.wookoo.roommultientities.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import io.wookoo.roommultientities.entities.Student
import io.wookoo.roommultientities.entities.Subject

data class StudentsWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>,
)
