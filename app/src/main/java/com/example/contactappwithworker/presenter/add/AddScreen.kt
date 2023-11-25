package com.example.contactappwithworker.presenter.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.contactappwithworker.utils.Constants.INPUT_LENGTH
import com.example.contactappwithworker.utils.Constants.MASK
import com.example.contactappwithworker.utils.MaskVisualTransformation

class AddScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<AddViewModel>()
        AddScreenContent(events = viewModel::onEventDispatcher)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreenContent(
    events: (AddContract.Intent) -> Unit
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Adding Contacts",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 22.sp,
            modifier = Modifier
                .padding(top = 15.dp)
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center), verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = firstName,
                onValueChange = {
                    firstName = it.trim()
                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(65.dp)
                    .height(70.dp),
                label = { Text(text = "First Name") },
            )

            OutlinedTextField(
                value = lastName,
                onValueChange = {
                    lastName = it.trim()
                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(65.dp)
                    .height(70.dp),
                label = { Text(text = "Last Name") },
            )

            OutlinedTextField(
                value = phone,
                onValueChange = {
                    if (INPUT_LENGTH >= it.length) {
                        phone = it.filter { it.isDigit() }.trim()
                    }
                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(65.dp)
                    .height(70.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                visualTransformation = MaskVisualTransformation(MASK),
                singleLine = true,
                maxLines = 13,
                placeholder = { Text(text = "+998-9#-###-##-##") },
                label = { Text(text = "Phone") },
                keyboardActions = KeyboardActions(
                    onDone = {
                        events.invoke(
                            AddContract.Intent.AddButtonClick(
                                firstName,
                                lastName,
                                "+998".plus(phone),
                            )
                        )
                    }
                )
            )

            Button(
                onClick = {
                    events.invoke(
                        AddContract.Intent.AddButtonClick(
                            firstName,
                            lastName,
                            "+998".plus(phone),
                        )
                    )
                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
            ) {
                Text(text = "Add", fontSize = 22.sp)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPrev() {
    AddScreenContent() {}
}