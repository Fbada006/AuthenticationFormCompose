package com.example.authenticationformcompose.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.authenticationformcompose.AuthenticationMode
import com.example.authenticationformcompose.R

@Composable
fun ToggleAuthenticationMode(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    toggleAuthentication: () -> Unit
) {
    Surface(
        modifier = modifier
            .padding(top = 16.dp),
        elevation = 8.dp
    ) {
        TextButton(
            onClick = toggleAuthentication
        ) {
            Text(
                text = stringResource(
                    if (authenticationMode ==
                        AuthenticationMode.SIGN_IN
                    ) {
                        R.string.action_need_account
                    } else {
                        R.string.action_already_have_account
                    }
                )
            )
        }
    }
}