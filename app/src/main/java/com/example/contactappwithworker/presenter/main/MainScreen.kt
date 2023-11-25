package com.example.contactappwithworker.presenter.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.contactappwithworker.presenter.components.ContactItem
import com.example.contactappwithworker.presenter.components.ToolBarView

class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: MainContract.ViewModel = getViewModel<MainViewModel>()
        MainScreenContent(uiState = viewModel.uiState.collectAsState(), onEventDispatcher = viewModel::onEventDispatcher)
    }
}

@Composable
fun MainScreenContent(
    uiState: State<MainContract.UIState>,
    onEventDispatcher: (MainContract.Intent) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        ToolBarView(
            title = "Contacts",
            hasBackButton = false,
            hasAdditionalButton = true,
            onAdditionalClick = { onEventDispatcher(MainContract.Intent.Settings) }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 56.dp),
            contentPadding = PaddingValues(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(uiState.value.list) {
                ContactItem(
                    contactData = it,
                    onClick = {},
                    onEdit = { onEventDispatcher.invoke(MainContract.Intent.Edit(it)) },
                    onLongClick = { onEventDispatcher.invoke(MainContract.Intent.Delete(it)) })
            }
        }

        /*
        * onEventDispatcher(HomeContract.Intent.ClickAddButton)
        * */

        FloatingActionButton(
            onClick = { onEventDispatcher(MainContract.Intent.AddButton) },
            modifier = Modifier
                .padding(end = 25.dp, bottom = 25.dp)
                .size(60.dp)
                .align(Alignment.BottomEnd)
                .clip(CircleShape),
            containerColor = Color(0xFF1285B9),
            contentColor = Color(0xFF1285B9)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Icon(
                    imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center),
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPrev() {
    MainScreenContent(uiState = remember {
        mutableStateOf(MainContract.UIState())
    }) {}
}