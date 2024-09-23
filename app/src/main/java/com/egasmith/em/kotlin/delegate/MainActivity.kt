package com.egasmith.em.kotlin.delegate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.egasmith.em.kotlin.delegate.ui.theme.EM1KotlinDelegateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EM1KotlinDelegateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val startTime = GetTime()
                    startTime.time

                    Box(modifier = Modifier.padding(innerPadding)) {
                        Text("Timer is start")
                    }
                }
            }
        }
    }
}

