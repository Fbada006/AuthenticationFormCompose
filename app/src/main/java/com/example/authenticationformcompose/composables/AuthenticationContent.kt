package com.example.authenticationformcompose.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.authenticationformcompose.AuthenticationEvent
import com.example.authenticationformcompose.AuthenticationState

@Composable
fun AuthenticationContent(
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if (authenticationState.isLoading) {
            CircularProgressIndicator()
        } else {
            AuthenticationForm(
                authenticationMode = authenticationState.authenticationMode,
                email = authenticationState.email,
                password = authenticationState.password,
                completedPasswordRequirements = authenticationState.passwordRequirements,
                enableAuthentication = authenticationState.isFormValid(),
                onEmailChanged = { email ->
                    handleEvent(AuthenticationEvent.EmailChanged(email))
                },
                onPasswordChanged = { password ->
                    handleEvent(
                        AuthenticationEvent.PasswordChanged(password)
                    )
                },
                onAuthenticate = {
                    handleEvent(
                        AuthenticationEvent.Authenticate
                    )
                },
                onToggleMode = {
                    handleEvent(
                        AuthenticationEvent.ToggleAuthenticationMode
                    )
                }
            )

            authenticationState.error?.let { error ->
                AuthenticationErrorDialog(
                    error = error,
                    dismissError = {
                        handleEvent(AuthenticationEvent.ErrorDismissed)
                    }
                )
            }
        }
    }
}