package org.example.applyspy.jobapplications.infrastructure.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JobApplicationDao {
    @Query("SELECT * FROM job_application")
    suspend fun getAll(): List<JobApplicationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(jobApplication: JobApplicationEntity)

    @Query("DELETE FROM job_application")
    suspend fun deleteById(id: String)
}