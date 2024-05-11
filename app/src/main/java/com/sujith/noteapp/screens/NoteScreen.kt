package com.sujith.noteapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sujith.noteapp.R
import com.sujith.noteapp.components.NoteButton
import com.sujith.noteapp.components.NoteInputText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen() {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.app_name))
            },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Call,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { }
                        .padding(10.dp)
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFDADFE3))
        )

        //content
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = title,
                label = "Title",
                onTextChange = { if (it.all { char ->char.isLetter() || char.isWhitespace() }) title = it })
            NoteInputText(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = description,
                label = "Add a note",
                maxLine = 3,
                onTextChange = { if (it.all { char ->char.isLetter() || char.isWhitespace() }) description = it})
            NoteButton(text1 = "Save", onClick = { /*TODO*/ })
        }

    }
}


@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}