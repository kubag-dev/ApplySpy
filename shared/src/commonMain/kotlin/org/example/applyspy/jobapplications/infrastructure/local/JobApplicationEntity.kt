package org.example.applyspy.jobapplications.infrastructure.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "job_application")
data class JobApplicationEntity(
    @PrimaryKey val id: String,
    val companyName: String,
    val position: String,
    val status: String,
    val salaryRange: String?
)
