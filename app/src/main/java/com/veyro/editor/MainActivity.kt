package com.veyro.editor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VeyroHome()
        }
    }
}

@Composable
fun VeyroHome() {

    val background = Color(0xFF09090B)
    val surface = Color(0xFF151518)
    val primary = Color(0xFF7C5CFF)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(22.dp)
    ) {

        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(
                    text = "VEYRO",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Video Editor",
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }

            TextButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "Create something.",
            color = Color.White,
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Start editing your next video.",
            color = Color.Gray,
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 6.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        // New Project
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = primary
            )
        ) {

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )

            Text(
                text = "  New Project",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Import Media
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = surface
            )
        ) {

            Icon(
                imageVector = Icons.Default.FolderOpen,
                contentDescription = null,
                tint = Color.White
            )

            Text(
                text = "  Import Media",
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(38.dp))

        Text(
            text = "Recent Projects",
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = surface
            )
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "No projects yet",
                        color = Color.White,
                        fontSize = 15.sp
                    )

                    Text(
                        text = "Your projects will appear here.",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }
        }
    }
}