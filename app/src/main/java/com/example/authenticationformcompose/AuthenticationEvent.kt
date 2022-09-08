package com.example.authenticationformcompose

sealed class AuthenticationEvent {

    object ToggleAuthenticationMode : AuthenticationEvent()
    data class EmailChanged(val emailAddress: String) : AuthenticationEvent()
    data class PasswordChanged(val password: String) : AuthenticationEvent()
    object Authenticate : AuthenticationEvent()
    object ErrorDismissed : AuthenticationEvent()
}