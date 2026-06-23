package org.example.applyspy.jobapplications.domain

data class JobApplication (
    val id: String,
    val companyName: String,
    val position: String,
    val status: ApplicationStatus,
    val salaryRange: String? = null
)
