package io.wookoo.roommultientities.schooldatabasse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.wookoo.roommultientities.dao.SchoolDao
import io.wookoo.roommultientities.entities.Director
import io.wookoo.roommultientities.entities.School
import io.wookoo.roommultientities.entities.Student
import io.wookoo.roommultientities.entities.Subject
import io.wookoo.roommultientities.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {
    abstract val schoolDao: SchoolDao

    companion object {
        private const val DATABASE_NAME = "school_db"

        @Volatile
        private var instance: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return instance ?: Room.databaseBuilder(
                    context.applicationContext, SchoolDatabase::class.java,
                    DATABASE_NAME
                ).build().also {
                    instance = it
                }
            }
        }
    }
}
