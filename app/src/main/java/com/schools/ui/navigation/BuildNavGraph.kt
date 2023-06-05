package com.schools.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.schools.ui.screens.HomeScreen
import com.schools.ui.screens.SchoolsDetailScreen
import com.schools.ui.screens.SchoolsScreen
import com.schools.viewmodel.MainViewModel

@Composable
fun BuildNavGraph(navController: NavHostController, viewModel: MainViewModel) {

    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ) {
        addHomeScreen(navController,this, viewModel)
        addSchoolsScreen(navController,this, viewModel)
        addSchoolsDetailScreen(this, viewModel)
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    viewModel: MainViewModel
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        HomeScreen(
            navigateToSchoolsList = {
                navController.navigate(NavRoute.SchoolList.path)
            },
            viewModel = viewModel,
        )
    }
}

private fun addSchoolsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    viewModel: MainViewModel
) {
    navGraphBuilder.composable(route = NavRoute.SchoolList.path) {
        SchoolsScreen(
            navigateToDetail = {
                navController.navigate(NavRoute.SchoolDetail.path)
            },
            viewModel = viewModel
        )
    }
}

private fun addSchoolsDetailScreen(
    navGraphBuilder: NavGraphBuilder,
    viewModel: MainViewModel
) {
    navGraphBuilder.composable(route = NavRoute.SchoolDetail.path) {
        SchoolsDetailScreen(
            viewModel = viewModel
        )
    }
}
