package org.example.applyspy.jobapplications.infrastructure

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.applyspy.jobapplications.domain.JobApplication
import org.example.applyspy.jobapplications.domain.JobApplicationRepository
import org.example.applyspy.jobapplications.infrastructure.local.JobApplicationDao

class RoomJobApplicationRepository(
    private val jobApplicationDao: JobApplicationDao,
    private val mapper: JobApplicationMapper
) : JobApplicationRepository {
    override fun getJobApplications(): Flow<List<JobApplication>> = flow {
        val entities = jobApplicationDao.getAll()
        val domainModels = entities.map { mapper.toDomain(it) }
        emit(domainModels)
    }

    override suspend fun saveApplication(application: JobApplication) {
        jobApplicationDao.insert(mapper.toEntity(application))
    }

    override suspend fun deleteApplication(id: String) {
        jobApplicationDao.deleteById(id)
    }
}