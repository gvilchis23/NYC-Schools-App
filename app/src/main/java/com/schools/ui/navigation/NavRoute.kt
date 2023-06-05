package com.schools.ui.navigation

sealed class NavRoute(val path: String) {

    object Home: NavRoute("home")

    object SchoolList: NavRoute("schoolList")

    object SchoolDetail: NavRoute("schoolDetail")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }

    fun withArgsFormat(vararg args: String) : String {
        return buildString {
            append(path)
            args.forEach{ arg ->
                append("/{$arg}")
            }
        }
    }
}