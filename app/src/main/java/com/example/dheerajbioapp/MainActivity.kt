package com.example.dheerajbioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dheerajbioapp.data.model.ProfileData
import com.example.dheerajbioapp.ui.screens.PortfolioScreen

/**
 * Main activity serving as the entry point for the application
 *
 * This activity follows the single activity architecture pattern,
 * hosting the Compose UI without managing any business logic.
 */
class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Display portfolio screen with user data
            PortfolioScreen(userProfile = ProfileData.dheerajProfile)
        }
    }
}
