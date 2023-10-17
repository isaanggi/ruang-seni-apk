package com.isaanggi.ruangseni

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isaanggi.ruangseni.ui.theme.RuangSeniTheme

val data: Data = Data()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RuangSeniTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    DisplaySeni()
                }
            }
        }
    }
}

@Composable
fun DisplaySeni() {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            DisplaySeniLandscape()
        }
        else -> {
            DisplaySeniPortrait()
        }
    }
}

@Composable
fun DisplaySeniPortrait() {
    var tampilGambar by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxHeight()
    ) {
        Surface(
            modifier = Modifier
                .border(width = 2.dp, color = Color.DarkGray)
                .align(alignment = CenterHorizontally),
        ) {
            Image(
                painter = painterResource(
                    id = data.dataGambar[tampilGambar].sumber
                ),
                contentDescription = stringResource(
                    id = data.dataGambar[tampilGambar].deskripsi
                ),
                modifier = Modifier
                    .padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Surface(
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(
                        data.dataGambar[tampilGambar].deskripsi
                    ),
                    fontSize = 17.sp
                )
                Text(
                    text = stringResource(
                        data.dataGambar[tampilGambar].karya
                    )
                        .plus(" (")
                        .plus(
                            stringResource(data.dataGambar[tampilGambar].tahun)
                                .plus(")")
                        ),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            modifier = Modifier
                .align(
                    alignment = CenterHorizontally
                )
                .padding(20.dp)
        ) {
            Button(
                onClick = {
                    if (tampilGambar != 0) {
                        tampilGambar -= 1
                    }
                },
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = {
                if (tampilGambar < 4) {
                    tampilGambar += 1
                } else {
                    tampilGambar = 0
                }
            }, modifier = Modifier.width(120.dp)) {
                Text(text = "Next")
            }
        }
        Row(
            modifier = Modifier
                .align(
                    alignment = CenterHorizontally
                )
                .padding(2.dp)
        ) {
            Text(text = "NIM: 215411037")
        }
        Row(
            modifier = Modifier
                .align(
                    alignment = CenterHorizontally
                )
                .padding(2.dp)
        ) {
            Text(text = "NAMA: ISA ANGGIE ALFIANTO")
        }
    }
}

@Composable
fun DisplaySeniLandscape() {
    var tampilGambar by remember {
        mutableStateOf(0)
    }
    Row(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize()
    ) {
        Surface(
            modifier = Modifier
                .border(width = 2.dp, color = Color.DarkGray)
                .align(alignment = CenterVertically),
        ) {
            Image(
                painter = painterResource(
                    id = data.dataGambar[tampilGambar].sumber
                ),
                contentDescription = stringResource(
                    id = data.dataGambar[tampilGambar].deskripsi
                ),
                modifier = Modifier
                    .padding(20.dp)
                    .height(100.dp)
                    .align(alignment = Alignment.Top)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Surface(
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(
                        data.dataGambar[tampilGambar].deskripsi
                    ),
                    fontSize = 17.sp,
                    modifier = Modifier.width(100.dp)
                )
                Text(
                    text = stringResource(
                        data.dataGambar[tampilGambar].karya
                    )
                        .plus(" (")
                        .plus(
                            stringResource(data.dataGambar[tampilGambar].tahun)
                                .plus(")")
                        ),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            modifier = Modifier
                .align(
                    alignment = CenterVertically
                )
                .padding(20.dp)
        ) {
            Button(
                onClick = {
                    if (tampilGambar != 0) {
                        tampilGambar -= 1
                    }
                },
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = {
                if (tampilGambar < 4) {
                    tampilGambar += 1
                } else {
                    tampilGambar = 0
                }
            }, modifier = Modifier.width(120.dp)) {
                Text(text = "Next")
            }
        }
        Row(
            modifier = Modifier
                .align(
                    alignment = CenterVertically
                )
                .padding(2.dp)
        ) {
            Text(text = "NIM: 215411037")
        }
        Row(
            modifier = Modifier
                .align(
                    alignment = CenterVertically
                )
                .padding(2.dp)
        ) {
            Text(text = "NAMA: ISA ANGGIE ALFIANTO")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RuangSeniPreview() {
    RuangSeniTheme {
        DisplaySeniLandscape()
    }
}