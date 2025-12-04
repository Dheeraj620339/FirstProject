package com.example.dheerajbioapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dheerajbioapp.ui.theme.AppColors
import com.example.dheerajbioapp.ui.theme.AppTypography

/**
 * Card component displaying a list of skills with checkmark chips
 *
 * @param skills List of skill names to display
 * @param modifier Optional modifier for customization
 */
@Composable
fun SkillsCard(
    skills: List<String>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppColors.CardBackground
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Skills & Strengths",
                fontSize = AppTypography.TitleMedium,
                fontWeight = AppTypography.Bold,
                color = AppColors.AccentYellow
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Display each skill
            skills.forEachIndexed { index, skill ->
                SkillChip(skill = skill)
                if (index < skills.size - 1) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

/**
 * Individual skill chip with checkmark icon
 *
 * @param skill Skill name to display
 */
@Composable
private fun SkillChip(skill: String) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = AppColors.SkillChipBackground,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "✓ $skill",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            fontSize = AppTypography.BodyLarge,
            color = AppColors.TextPrimary,
            fontWeight = AppTypography.Medium
        )
    }
}
