package com.sujith.noteapp.repository

import com.sujith.noteapp.data.NoteDatabaseDao
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {

}