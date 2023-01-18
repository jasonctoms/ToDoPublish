package com.kay.todopublish.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kay.todopublish.ui.screens.task.TaskScreen
import com.kay.todopublish.util.Action
import com.kay.todopublish.util.Constants.TASK_ARGUMENT_KEY
import com.kay.todopublish.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        // specify what argument the screen will have
        route = TASK_SCREEN,
        arguments = listOf(
            navArgument(TASK_ARGUMENT_KEY) {
                type = NavType.IntType
            }
        )
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        TaskScreen(
            navigateToListScreen = navigateToListScreen,
            taskId = taskId
        )
    }
}
