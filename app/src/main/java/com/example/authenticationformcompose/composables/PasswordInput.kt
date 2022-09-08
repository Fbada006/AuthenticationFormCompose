package com.example.authenticationformcompose.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.authenticationformcompose.R

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChanged: (email: String) -> Unit,
    onDoneClicked: () -> Unit
) {
    var isPasswordHidden by remember { mutableStateOf(true) }

    TextField(modifier = modifier, value = password, onValueChange = {
        onPasswordChanged(it)
    }, singleLine = true, label = {
        Text(text = stringResource(id = R.string.label_password))
    }, leadingIcon = {
        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = stringResource(id = R.string.cd_pass_lock)
        )
    }, trailingIcon = {
        Icon(
            modifier = Modifier.clickable(
                onClickLabel = if (isPasswordHidden) {
                    stringResource(
                        id = R.string.cd_show_password
                    )
                } else stringResource(
                    id = R.string.cd_hide_password
                )
            ) {
                isPasswordHidden = !isPasswordHidden
            }, imageVector = if (isPasswordHidden) {
                Icons.Default.Visibility
            } else Icons.Default.VisibilityOff, contentDescription = null
        )
    }, visualTransformation = if (isPasswordHidden) {
        PasswordVisualTransformation()
    } else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onDoneClicked()
            }
        )
    )
}