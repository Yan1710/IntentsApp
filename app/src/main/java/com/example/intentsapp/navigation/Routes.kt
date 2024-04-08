package com.example.intentsapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(
    val icon:ImageVector,
    val title:String,
    val routes:String
){
    object phoneView:Routes(Icons.Default.Phone,"Phone","PhoneViews")
    object SmsView:Routes(Icons.Default.Person,"SMS","SmsViews")
    object EmailView:Routes(Icons.Default.Email,"Email","EmailView")
}