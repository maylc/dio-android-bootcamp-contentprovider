package io.github.maylcf.contentprovider

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.github.maylcf.contentprovider.database.NotesDatabaseHelper.Companion.TITLE_NOTES
import io.github.maylcf.contentprovider.database.NotesProvider.Companion.URI_NOTES

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor> {

    lateinit var notesRecyclerView: RecyclerView
    lateinit var notesAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesAdd = findViewById(R.id.notes_add)
        notesRecyclerView = findViewById(R.id.notes_recycler)
    }

    // LoaderManager.LoaderCallbacks<Cursor>

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> =
            CursorLoader(this, URI_NOTES, null, null, null, TITLE_NOTES)

    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        if (data != null) {

        }
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        TODO("Not yet implemented")
    }
}