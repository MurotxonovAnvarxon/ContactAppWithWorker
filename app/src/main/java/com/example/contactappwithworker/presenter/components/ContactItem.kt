package com.example.contactappwithworker.presenter.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactappwithworker.R
import com.example.contactappwithworker.data.common.ContactData

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactItem(
    contactData: ContactData,
    onClick: (ContactData) -> Unit,
    onEdit: (ContactData) -> Unit,
    onLongClick: (ContactData) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(90.dp)
            .combinedClickable(
                onClick = {  },
                onLongClick = { onLongClick.invoke(contactData) })
            .background(color = Color.Transparent),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth()
                    .align(Alignment.CenterStart),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(5.dp)
                        .clip(
                            CircleShape
                        )
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth()
                    .align(Alignment.Center)
            ) {
                Text(
                    text = contactData.firstName,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                )

                Text(
                    text = contactData.lastName,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                )


                Text(
                    text = contactData.phone,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(top = 5.dp, start = 10.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.baseline_edit_24),
                contentDescription = "edit btn",
                modifier = Modifier
                    .padding(end = 40.dp)
                    .fillMaxHeight()
                    .width(40.dp)
                    .align(Alignment.CenterEnd).clickable { onEdit.invoke(contactData) },

            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth()
                    .align(Alignment.CenterEnd)
                    .padding(end = 20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = if (contactData.state) R.drawable.baseline_check_24 else R.drawable.baseline_access_time_24),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ItemContactPreview() {
    ContactItem(
        contactData = ContactData(1, "", "", "", false, ""),
        onClick = {},
        onEdit = {},
        onLongClick = {})
}