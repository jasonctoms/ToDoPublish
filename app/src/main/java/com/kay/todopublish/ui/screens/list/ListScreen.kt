package com.kay.todopublish.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kay.todopublish.R
import com.kay.todopublish.ui.screens.list.topbar.ListAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(navigateToTaskScreen: (Int) -> Unit) {
    Scaffold(
        topBar = { ListAppBar() },
        content = {},
        floatingActionButton = {
            ListFloatingActionButton(onFloatingActionButtonClicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFloatingActionButton(onFloatingActionButtonClicked: (Int) -> Unit) {
    // Define our floating action button
    FloatingActionButton(
        onClick = {
            onFloatingActionButtonClicked(-1/*(<- Assign an id number here)*/)
        }
    ) {
        // Add an icon to our floating action button
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button),
            tint = Color.White
        )
    }
}

@Composable
@Preview
private fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}
