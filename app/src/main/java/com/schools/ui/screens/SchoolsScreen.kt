package com.schools.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.schools.viewmodel.MainViewModel

@Composable
fun SchoolsScreen(
    navigateToDetail: () -> Unit,
    viewModel: MainViewModel) {

    Column {
        //this IF condition is a workaround to an issue for loading the screen after the first time.
        if (viewModel.schoolsList != null) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                items(items = viewModel.schoolsList!!) { schools ->
                    SchoolsItem(schools = schools, viewModel = viewModel, navigateToDetail = navigateToDetail)
                }
            }
        }
    }
}
