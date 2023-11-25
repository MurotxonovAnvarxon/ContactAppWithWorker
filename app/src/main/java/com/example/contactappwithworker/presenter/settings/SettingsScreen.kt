package com.example.contactappwithworker.presenter.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel

class SettingsScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<SettingsViewModel>()
        SettingsScreenContent(
            uiState = viewModel.uiState.collectAsState(),
            onEventDispatcher = viewModel::onEventDispatcher
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreenContent(
    uiState: State<SettingsContract.UIState>,
    onEventDispatcher: (SettingsContract.Intent) -> Unit
) {
    var hour by remember { mutableStateOf("") }
    val minTime = 15

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Settings",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 22.sp,
            modifier = Modifier
                .padding(top = 15.dp)
                .align(Alignment.TopCenter)
        )
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(
                text = "Please input time \nPlease enter more than 15",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = hour,
                onValueChange = {
                    hour = it
                },
                modifier = Modifier
                    .padding(horizontal = 25.dp, vertical = 10.dp)
                    .fillMaxWidth()
                    .height(56.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF0A459C),
                    unfocusedBorderColor = Color(0xFF7397CE),
                    cursorColor = Color(0xFF080809),
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = { Text(text = "Minutes") },
                label = { Text(text = "Minutes") }
            )

            Button(
                onClick = { onEventDispatcher(SettingsContract.Intent.CLickTime) },
                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxWidth(),
            ) {
                Text(text = "Set", fontSize = 22.sp)

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPrev() {
    SettingsScreenContent(uiState = remember {
        mutableStateOf(SettingsContract.UIState())
    }) {}
}