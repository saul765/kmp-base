package com.example.kmp_base

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kmp_base.ui.ComposeBaseApp
import com.example.kmp_base.ui.rememberComposeBaseNavigationState
import com.example.composebase.ui.theme.ComposeBaseTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    private val splashScreen by lazy { installSplashScreen() }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        splashScreen.setKeepOnScreenCondition {
            false
        }

        setContent {

            KoinContext {
                ComposeBaseTheme {
                    val navControllerState = rememberComposeBaseNavigationState()

                    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                    ComposeBaseApp(navControllerState, uiState)
                }
            }
        }
    }
}
