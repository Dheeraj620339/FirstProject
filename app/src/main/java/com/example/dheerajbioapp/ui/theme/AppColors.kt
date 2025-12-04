package com.example.dheerajbioapp.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Application color palette
 * Provides a consistent color scheme throughout the app
 */
object AppColors {
    // Primary gradient colors
    val GradientStart = Color(0xFF1A237E)  // Deep Blue
    val GradientMid = Color(0xFF4A148C)    // Deep Purple
    val GradientEnd = Color(0xFF311B92)    // Dark Purple
    
    // Accent colors
    val AccentYellow = Color(0xFFFFD93D)
    val AccentRed = Color(0xFFFF6B6B)
    
    // Text colors
    val TextPrimary = Color.White
    val TextSecondary = Color(0xFFB0BEC5)
    
    // Card colors
    val CardBackground = Color.White.copy(alpha = 0.1f)
    
    // Skill chip colors
    val SkillChipBackground = Color(0xFF4CAF50).copy(alpha = 0.3f)
}
