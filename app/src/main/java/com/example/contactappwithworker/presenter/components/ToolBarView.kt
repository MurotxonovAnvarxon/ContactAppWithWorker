package com.example.contactappwithworker.presenter.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactappwithworker.R


@Composable
fun ToolBarView(
    title: String = "",
    hasBackButton: Boolean = true,
    @DrawableRes backIcon: Int = R.drawable.baseline_arrow_back_24,
    onBackClick: () -> Unit = {},
    hasAdditionalButton: Boolean = false,
    @DrawableRes additionalIcon: Int = R.drawable.baseline_settings_24,
    onAdditionalClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFF1285B9))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (hasBackButton) {
            IconButton(
                modifier = Modifier
                    .clip(CircleShape),
                onClick = onBackClick
            ) {
                Icon(
                    painter = painterResource(id = backIcon),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
        }

        Text(
            text = title,
            fontSize = 24.sp,
            color = Color(0xFFFFFFFF),
            modifier = Modifier.weight(1f, true),
            textAlign = TextAlign.Start
        )

        if (hasAdditionalButton) {
            Spacer(modifier = Modifier.size(8.dp))


            IconButton(
                modifier = Modifier
                    .clip(CircleShape),
                onClick = onAdditionalClick
            ) {
                Icon(
                    painter = painterResource(id = additionalIcon),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}