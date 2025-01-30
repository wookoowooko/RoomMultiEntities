package io.wookoo.roommultientities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import io.wookoo.roommultientities.entities.Director
import io.wookoo.roommultientities.entities.School
import io.wookoo.roommultientities.entities.Student
import io.wookoo.roommultientities.entities.Subject
import io.wookoo.roommultientities.entities.relations.SchoolAndDirector
import io.wookoo.roommultientities.entities.relations.SchoolWithStudents
import io.wookoo.roommultientities.entities.relations.StudentSubjectCrossRef
import io.wookoo.roommultientities.entities.relations.StudentsWithSubjects
import io.wookoo.roommultientities.entities.relations.SubjectWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String):List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String):List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE schoolName = :studentName")
    suspend fun getSubjectsOfStudent(studentName: String):List<StudentsWithSubjects>
}