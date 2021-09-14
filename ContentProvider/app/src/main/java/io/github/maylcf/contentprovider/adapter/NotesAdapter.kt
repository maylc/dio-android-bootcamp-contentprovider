package io.github.maylcf.contentprovider.adapter

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.maylcf.contentprovider.R
import io.github.maylcf.contentprovider.database.NotesDatabaseHelper.Companion.DESCRIPTION_NOTES
import io.github.maylcf.contentprovider.database.NotesDatabaseHelper.Companion.TITLE_NOTES

class NotesAdapter(private val listener: NoteClickListener) : RecyclerView.Adapter<NotesViewHolder>() {

    private var cursor: Cursor? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder = NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        cursor?.moveToPosition(position)

        holder.noteTitle.text = cursor?.getString(cursor?.getColumnIndex(TITLE_NOTES) as Int)
        holder.noteDescription.text = cursor?.getString(cursor?.getColumnIndex(DESCRIPTION_NOTES) as Int)
        holder.removeButton.setOnClickListener {
            cursor?.moveToPosition(position)
            listener.onRemoveNoteClicked(cursor)
            notifyDataSetChanged()
        }

        holder.itemView.setOnClickListener {
            listener.onNoteItemClicked(cursor as Cursor)
        }
    }

    override fun getItemCount(): Int = if (cursor != null) {
        cursor?.count as Int
    } else {
        0
    }

    fun setCursor(newCursor: Cursor?) {
        this.cursor = newCursor
        notifyDataSetChanged()
    }
}


class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val noteTitle = itemView.findViewById<TextView>(R.id.note_title)
    val noteDescription = itemView.findViewById<TextView>(R.id.note_description)
    val removeButton = itemView.findViewById<TextView>(R.id.note_remove_button)
}