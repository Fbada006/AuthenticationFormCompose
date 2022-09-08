package com.example.authenticationformcompose.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authenticationformcompose.AuthenticationViewModel

@Composable
fun Authentication() {
    val viewModel: AuthenticationViewModel = viewModel()
    val authenticationState by viewModel.uiState.collectAsState()

    MaterialTheme {
        AuthenticationContent(
            modifier = Modifier.fillMaxWidth(),
            authenticationState = authenticationState,
            handleEvent = { event -> viewModel.handleEvent(event) }
        )
    }
}