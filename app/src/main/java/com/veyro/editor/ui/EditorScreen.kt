package com.veyro.editor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
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
            .background(Color(0xFF090B0F))
    ) {

        // =====================================================
        // TOP BAR
        // =====================================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFF11141A))
                .padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "VEYRO",
                color = Color.White,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            TextButton(onClick = {}) {
                Text(
                    text = "UNDO",
                    color = Color(0xFF9BA3AF),
                    fontSize = 11.sp
                )
            }

            TextButton(onClick = {}) {
                Text(
                    text = "REDO",
                    color = Color(0xFF9BA3AF),
                    fontSize = 11.sp
                )
            }

            TextButton(onClick = {}) {
                Text(
                    text = "EXPORT",
                    color = Color.White,
                    fontSize = 11.sp
                )
            }
        }

        // =====================================================
        // PREVIEW AREA
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 12.dp, vertical = 10.dp)
                .background(Color.Black)
                .border(
                    width = 1.dp,
                    color = Color(0xFF252A33)
                ),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "VEYRO",
                    color = Color(0xFF303640),
                    fontSize = 28.sp
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Preview",
                    color = Color(0xFF555C68),
                    fontSize = 13.sp
                )
            }
        }

        // =====================================================
        // EDITING TOOLBAR
        // =====================================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(Color(0xFF11141A)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            EditorTool("MEDIA")
            EditorTool("TEXT")
            EditorTool("AUDIO")
            EditorTool("EFFECT")
            EditorTool("LAYER")
        }

        // =====================================================
        // TIMELINE HEADER
        // =====================================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp)
                .background(Color(0xFF141820))
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "TIMELINE",
                color = Color.White,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "00:00:00",
                color = Color(0xFF8B929D),
                fontSize = 12.sp
            )
        }

        // =====================================================
        // TIMELINE
        // =====================================================

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .background(Color(0xFF181B21))
        ) {

            // Timeline ruler
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .horizontalScroll(
                        rememberScrollState()
                    )
                    .background(Color(0xFF11141A)),
                verticalAlignment = Alignment.CenterVertically
            ) {

                for (i in 0..10) {

                    Box(
                        modifier = Modifier
                            .width(90.dp)
                            .fillMaxHeight()
                    ) {

                        Text(
                            text = "00:${"%02d".format(i)}",
                            color = Color(0xFF69717D),
                            fontSize = 10.sp,
                            modifier = Modifier.padding(
                                start = 8.dp,
                                top = 7.dp
                            )
                        )
                    }
                }
            }

            // Video track
            TimelineTrack(
                name = "VIDEO 01",
                color = Color(0xFF315A8A)
            )

            // Text track
            TimelineTrack(
                name = "TEXT",
                color = Color(0xFF674A91)
            )

            // Audio track
            TimelineTrack(
                name = "AUDIO",
                color = Color(0xFF3D7059)
            )
        }
    }
}

@Composable
private fun TimelineTrack(
    name: String,
    color: Color
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(42.dp)
            .background(Color(0xFF1C2027))
            .border(
                width = 0.5.dp,
                color = Color(0xFF292E37)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .width(88.dp)
                .fillMaxHeight()
                .background(Color(0xFF15181E)),
            contentAlignment = Alignment.CenterStart
        ) {

            Text(
                text = name,
                color = Color(0xFF9AA2AE),
                fontSize = 10.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }

        Box(
            modifier = Modifier
                .width(160.dp)
                .height(28.dp)
                .background(color)
        )
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
            fontSize = 11.sp
        )
    }
}