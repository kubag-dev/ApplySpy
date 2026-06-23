package org.example.applyspy.jobapplications.infrastructure

import org.example.applyspy.jobapplications.domain.ApplicationStatus
import org.example.applyspy.jobapplications.domain.JobApplication
import org.example.applyspy.jobapplications.infrastructure.local.JobApplicationEntity

class JobApplicationMapper {
    fun toDomain(entity: JobApplicationEntity): JobApplication {
        return JobApplication(
            id = entity.id,
            companyName = entity.companyName,
            position = entity.position,
            status = try {
                ApplicationStatus.valueOf(entity.status)
            } catch (e: IllegalArgumentException) {
                ApplicationStatus.UNKNOWN
            },
            salaryRange = entity.salaryRange,
        )
    }

    fun toEntity(domain: JobApplication): JobApplicationEntity {
        return JobApplicationEntity(
            id = domain.id,
            companyName = domain.companyName,
            position = domain.position,
            status = domain.status.name,
            salaryRange = domain.salaryRange,
        )
    }
}