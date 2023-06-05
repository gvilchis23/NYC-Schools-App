package com.schools.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.schools.data.Schools
import com.schools.viewmodel.MainViewModel

//the card onclick is on experimental api, but thought would be fun to see how it works.
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SchoolsItem(schools: Schools, viewModel: MainViewModel,  navigateToDetail: () -> Unit) {

    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = {
            viewModel.updateSatScores()
            navigateToDetail()
        },
    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                schools.dbn?.let { Text(text = it, style = MaterialTheme.typography.h4) }
                Text(text = "VIEW DETAIL", style = MaterialTheme.typography.caption)
            }
        }
    }
}


