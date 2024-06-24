package com.example.jobtalent.presentation.login.componentLogin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.example.jobtalent.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentForm(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    katasandiVisible: MutableState<Boolean>? = null,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = labelText,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFAEAEAE),
                )
            )
        },
        textStyle = TextStyle(color = Color(0xFF000000)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFAEAEAE),
            unfocusedBorderColor = Color(0xFFAEAEAE),
            containerColor = Color(0xFFF5F5F5),
        ),
        visualTransformation = if (isPassword && (katasandiVisible?.value == true)) VisualTransformation.None else if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = if (isPassword && katasandiVisible != null) {
            {
                val image =
                    if (katasandiVisible.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (katasandiVisible.value) "Hide password" else "Show password"

                IconButton(onClick = { katasandiVisible.value = !katasandiVisible.value }) {
                    Icon(imageVector = image, contentDescription = description)
                }
            }
        } else null
    )
}