package io.github.maylcf.client

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var notesRecyclerView: RecyclerView
    lateinit var notesRefreshButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesRecyclerView = findViewById(R.id.client_list)
        notesRefreshButton = findViewById(R.id.client_button_refresh)

        notesRefreshButton.setOnClickListener {
            getContentProvider()
        }
    }

    private fun getContentProvider() {
        try {
            val uri = "content://io.github.maylcf.contentprovider.provider/notes"
            val data = Uri.parse(uri)
            val cursor: Cursor? = contentResolver.query(data, null, null, null, "title")

            notesRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = ClientAdapter(cursor as Cursor)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}