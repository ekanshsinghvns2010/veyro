package com.veyro.editor.ui

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EditorScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B0D10))
    ) {

        // Top toolbar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFF12151A))
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "VEYRO",
                color = Color.White,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            TextButton(onClick = {}) {
                Text("UNDO")
            }

            TextButton(onClick = {}) {
                Text("REDO")
            }

            TextButton(onClick = {}) {
                Text("EXPORT")
            }
        }

        // Preview
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(12.dp)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "Preview",
                color = Color(0xFF70757D),
                fontSize = 18.sp
            )
        }

        // Tool bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(Color(0xFF12151A)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            EditorTool("MEDIA")
            EditorTool("TEXT")
            EditorTool("AUDIO")
            EditorTool("EFFECT")
        }

        // Timeline
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color(0xFF171A20))
                .padding(10.dp)
        ) {

            Text(
                text = "TIMELINE",
                color = Color.White,
                fontSize = 14.sp
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(Color(0xFF242831))
            ) {

                Text(
                    text = "No layers",
                    color = Color(0xFF777D87),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
private fun EditorTool(
    title: String
) {

    TextButton(
        onClick = {}
    ) {

        Text(
            text = title,
            color = Color.White,
            fontSize = 12.sp
        )
    }
}