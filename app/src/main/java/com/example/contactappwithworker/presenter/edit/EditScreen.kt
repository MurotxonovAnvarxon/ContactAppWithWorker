package com.example.contactappwithworker.presenter.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.contactappwithworker.data.common.ContactData

class EditScreen(val contactData: ContactData) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<EditViewModel>()
        EditScreenContent(
            uiState = viewModel.uiState.collectAsState(),
            onEventDispatcher = viewModel::onEventDispatcher,
            contactData = contactData
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenContent(
    contactData: ContactData,
    uiState: State<EditContract.UIState>,
    onEventDispatcher: (EditContract.Intent) -> Unit,
) {
    val uiStateController = rememberSystemUiController()

    SideEffect {
        uiStateController.setSystemBarsColor(color = Color.White)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        var firstName by remember { mutableStateOf( contactData.firstName) }
        var lastName by remember { mutableStateOf(contactData.lastName) }
        var phone by remember { mutableStateOf(contactData.phone) }
        Text(
            text = "Updating Contacts",
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

            TextField(
                value =firstName,
                onValueChange = {
                    firstName=it
                    onEventDispatcher(EditContract.Intent.ChangingName(firstName))
                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(65.dp)
                    .height(70.dp),
                label = { Text(text = "First Name") },
            )

            TextField(
                value = lastName,
                onValueChange = {
                    lastName=it
                    onEventDispatcher(EditContract.Intent.ChangingLastName(lastName))
                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(65.dp)
                    .height(70.dp),
                label = { Text(text = "Last Name") },
            )


            TextField(
                value = phone,
                onValueChange = {
                    phone=it
                    onEventDispatcher(EditContract.Intent.ChangingPhone(phone))
                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(65.dp)
                    .height(70.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                singleLine = true,
                label = { Text(text = "Phone") },
            )

            Button(
                onClick = {
                    onEventDispatcher.invoke(
                        EditContract.Intent.EditContact(uiState.value.contactData.firstName,uiState.value.contactData.lastName,uiState.value.contactData.phone)
                    )
                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
            ) {
                Text(text = "Update", fontSize = 22.sp)

            }
        }
    }
}

