package io.github.maylcf.contentprovider.adapter

import android.database.Cursor

interface NoteClickListener {
    fun onNoteItemClicked(cursor: Cursor)
    fun onRemoveNoteClicked(cursor: Cursor?)
}