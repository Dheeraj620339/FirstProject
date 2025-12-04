package com.example.dheerajbioapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.dheerajbioapp.ui.theme.AppColors
import com.example.dheerajbioapp.ui.theme.AppTypography

/**
 * Profile header component displaying user avatar and basic info
 *
 * @param name User's full name
 * @param initials User's initials for avatar
 * @param title User's professional title/tagline
 */
@Composable
fun ProfileHeader(
    name: String,
    initials: String,
    title: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        // Profile Avatar with gradient background
        ProfileAvatar(initials = initials)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // User name
        Text(
            text = name,
            fontSize = AppTypography.TitleLarge,
            fontWeight = AppTypography.Bold,
            color = AppColors.TextPrimary
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        // Professional title
        Text(
            text = title,
            fontSize = AppTypography.BodyMedium,
            color = AppColors.TextSecondary
        )
    }
}

/**
 * Circular avatar with gradient background and user initials
 *
 * @param initials User initials to display
 */
@Composable
private fun ProfileAvatar(initials: String) {
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
            .background(
                Brush.linearGradient(
                    listOf(
                        AppColors.AccentRed,
                        AppColors.AccentYellow
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials,
            fontSize = AppTypography.ProfileInitials,
            fontWeight = AppTypography.Bold,
            color = AppColors.TextPrimary
        )
    }
}
