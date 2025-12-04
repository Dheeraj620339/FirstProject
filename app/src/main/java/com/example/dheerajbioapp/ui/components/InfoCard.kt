package com.example.dheerajbioapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dheerajbioapp.ui.theme.AppColors
import com.example.dheerajbioapp.ui.theme.AppTypography

/**
 * Reusable card component for displaying information sections
 *
 * @param title Section title
 * @param content Section content text
 * @param modifier Optional modifier for customization
 */
@Composable
fun InfoCard(
    title: String,
    content: String,
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
            // Section title
            Text(
                text = title,
                fontSize = AppTypography.TitleMedium,
                fontWeight = AppTypography.Bold,
                color = AppColors.AccentYellow
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Section content
            Text(
                text = content,
                fontSize = AppTypography.BodyLarge,
                color = AppColors.TextPrimary,
                lineHeight = 22.sp
            )
        }
    }
}
