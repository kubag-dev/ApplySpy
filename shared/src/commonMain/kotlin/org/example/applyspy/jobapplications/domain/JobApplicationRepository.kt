package org.example.applyspy.jobapplications.domain

import kotlinx.coroutines.flow.Flow

interface JobApplicationRepository {
    fun getJobApplications(): Flow<List<JobApplication>>
    suspend fun saveApplication(application: JobApplication)
    suspend fun deleteApplication(id: String)
}