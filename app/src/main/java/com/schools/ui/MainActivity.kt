package com.schools.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.schools.ui.navigation.BuildNavGraph
import com.schools.viewmodel.MainViewModel
import com.schools.ui.theme.SimpleRestApiAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen(viewModel())
        }
    }
}

@Composable
private fun MainScreen(viewModel: MainViewModel) {

    SimpleRestApiAppTheme {
        val navController = rememberNavController()
        BuildNavGraph(navController, viewModel)
    }
}
