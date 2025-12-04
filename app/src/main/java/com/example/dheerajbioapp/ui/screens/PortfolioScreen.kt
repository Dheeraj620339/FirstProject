package com.example.dheerajbioapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.dheerajbioapp.data.model.UserProfile
import com.example.dheerajbioapp.ui.components.*
import com.example.dheerajbioapp.ui.theme.AppColors

/**
 * Main portfolio screen displaying user profile and information
 *
 * This screen follows a card-based layout with scrollable content,
 * showcasing the user's professional information in an organized manner.
 *
 * @param userProfile User profile data to display
 * @param modifier Optional modifier for customization
 */
@Composable
fun PortfolioScreen(
    userProfile: UserProfile,
    modifier: Modifier = Modifier
) {
    val gradientColors = listOf(
        AppColors.GradientStart,
        AppColors.GradientMid,
        AppColors.GradientEnd
    )
    
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(gradientColors))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            // Profile header section
            ProfileHeader(
                name = userProfile.name,
                initials = userProfile.initials,
                title = userProfile.title
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // About section
            InfoCard(
                title = "About Me",
                content = userProfile.about
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Work section
            InfoCard(
                title = "Current Work",
                content = userProfile.currentWork
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Career goals section
            InfoCard(
                title = "Career Goals",
                content = userProfile.careerGoals
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Skills section
            SkillsCard(skills = userProfile.skills)
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Contact information section
            ContactCard(
                location = userProfile.location,
                workplace = "DishTV Customer Care",
                goals = "RRB Group D & SSC MTS Aspirant"
            )
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
