package com.schools.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.schools.viewmodel.MainViewModel

@Composable
fun SchoolsDetailScreen(
    viewModel: MainViewModel) {

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,)
    {

        //NOTE i am hardcoding to index zero, but i should be looking into the SAT list by the dbn number and using that object data.

        item {
            viewModel.satScoresList?.get(0)?.numSatTestTakers?.let { Text(text = it, style = MaterialTheme.typography.caption) }
            viewModel.satScoresList?.get(0)?.satAverageReading?.let { Text(text = it, style = MaterialTheme.typography.caption) }
            viewModel.satScoresList?.get(0)?.satMathAvg?.let { Text(text = it, style = MaterialTheme.typography.caption) }
            viewModel.satScoresList?.get(0)?.satWritingAvg?.let { Text(text = it, style = MaterialTheme.typography.caption) }
        }
    }
}
