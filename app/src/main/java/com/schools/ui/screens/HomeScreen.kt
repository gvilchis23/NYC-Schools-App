package com.schools.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.schools.R
import com.schools.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    navigateToSchoolsList: () -> Unit,
    viewModel: MainViewModel
) {

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        item {
            DefaultButton(
                text = stringResource(R.string.retrofit_gson),
                onClick = {
                    viewModel.updateSchoolsWithRetrofitGson()
                    navigateToSchoolsList()
                },
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen({}, MainViewModel())
}