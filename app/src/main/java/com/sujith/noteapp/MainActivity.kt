package com.sujith.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sujith.noteapp.data.NotesDataSource
import com.sujith.noteapp.model.Note
import com.sujith.noteapp.screens.NoteScreen
import com.sujith.noteapp.screens.NoteViewmodel
import com.sujith.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val viewModel: NoteViewmodel by viewModels()
                    NoteApp(viewModel)
                }

            }
        }


    }

    @Composable
    fun NoteApp(noteViewmodel: NoteViewmodel) {
        val notes = noteViewmodel.noteList.collectAsState().value
        NoteScreen(
            notes = notes,
            onAddNote = { noteViewmodel.addNote(it) },
            onRemoveNote = { noteViewmodel.deleteNote(it) })
    }
}

