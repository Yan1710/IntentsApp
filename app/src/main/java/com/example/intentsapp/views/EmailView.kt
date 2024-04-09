package com.example.intentsapp.views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmailView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        var email by remember { mutableStateOf("") }
        var subject by remember { mutableStateOf("") }
        var mesagge by remember { mutableStateOf("") }
        val context = LocalContext.current
        Text(text = "EMAIL", fontSize = 50.sp, fontWeight = FontWeight.Bold)

        OutlinedTextField(value = email, onValueChange = { email = it }, label = {
            Text(text = "Email")
        },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        OutlinedTextField(value = subject, onValueChange = { subject = it }, label = {
            Text(text = "Subject")
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )


        OutlinedTextField(value = mesagge, onValueChange = { mesagge = it }, label = {
            Text(text = "Mesagge")
        },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(10.dp)
        )

        Button(onClick = {
            val intent = Intent(Intent.ACTION_SEND)
            val emailAddress = arrayOf(email)
            intent.putExtra(Intent.EXTRA_EMAIL,emailAddress)
            intent.putExtra(Intent.EXTRA_SUBJECT,subject)
            intent.putExtra(Intent.EXTRA_TEXT,mesagge)
            intent.type = "message/rfc822"
            context.startActivity(Intent.createChooser(intent,"Email Client"))


        }) {
            Text(text = "Send")
        }

    }
}