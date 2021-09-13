package io.github.maylcf.contentprovider.adapter

import android.database.Cursor
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.maylcf.contentprovider.R

class NotesAdapter() : RecyclerView.Adapter<NotesViewHolder>() {

    private var cursor : Cursor? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder = NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun setCursor(newCursor: Cursor) {
        this.cursor = newCursor
        notifyDataSetChanged()
    }
}


class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val noteTitle = itemView.findViewById<TextView>(R.id.note_title)
    val noteDescription = itemView.findViewById<TextView>(R.id.note_description)
    val removeButton = itemView.findViewById<TextView>(R.id.note_remove_button)
}