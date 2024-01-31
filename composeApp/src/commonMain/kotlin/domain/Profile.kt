package domain

import androidx.compose.ui.graphics.vector.ImageVector

data class Profile(
    val userName: String,
    val email: String,
    val profilePic: ImageVector,
)