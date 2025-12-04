package com.example.dheerajbioapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dheerajbioapp.ui.theme.AppColors
import com.example.dheerajbioapp.ui.theme.AppTypography

/**
 * Contact information card component
 *
 * @param location User's location
 * @param workplace Current workplace
 * @param goals Career goals/aspirations
 * @param modifier Optional modifier for customization
 */
@Composable
fun ContactCard(
    location: String,
    workplace: String,
    goals: String,
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
                text = "Contact Info",
                fontSize = AppTypography.TitleMedium,
                fontWeight = AppTypography.Bold,
                color = AppColors.AccentYellow
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            ContactItem(icon = "📍", text = location)
            Spacer(modifier = Modifier.height(8.dp))
            ContactItem(icon = "💼", text = workplace)
            Spacer(modifier = Modifier.height(8.dp))
            ContactItem(icon = "🎯", text = goals)
        }
    }
}

/**
 * Individual contact information item with icon
 *
 * @param icon Emoji icon to display
 * @param text Information text
 */
@Composable
private fun ContactItem(
    icon: String,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = icon,
            fontSize = AppTypography.IconSize
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontSize = AppTypography.BodyLarge,
            color = AppColors.TextPrimary
        )
    }
}
