package com.example.dheerajbioapp.data.model

/**
 * Data model representing user profile information
 */
data class UserProfile(
    val name: String,
    val initials: String,
    val title: String,
    val about: String,
    val currentWork: String,
    val careerGoals: String,
    val location: String,
    val skills: List<String>
)

/**
 * Provides static profile data
 * In a production app, this would come from a repository/data source
 */
object ProfileData {
    val dheerajProfile = UserProfile(
        name = "Dheeraj Ravidas",
        initials = "DR",
        title = "Customer Care Professional | Aspiring Government Employee",
        about = "Hello! I'm Dheeraj Ravidas from Dhanbad, Jharkhand. I am passionate about technology and dedicated to achieving my career goals.",
        currentWork = "Working at DishTV Customer Care, providing excellent service and support to customers.",
        careerGoals = "Preparing for government examinations including RRB Group D and SSC MTS to serve the nation.",
        location = "Dhanbad, Jharkhand",
        skills = listOf(
            "Customer Service",
            "Communication",
            "Problem Solving",
            "Exam Preparation",
            "Dedication & Hard Work"
        )
    )
}
