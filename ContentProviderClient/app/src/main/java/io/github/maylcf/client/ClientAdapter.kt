package io.github.maylcf.client

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val clientTitle = itemView.findViewById<TextView>(R.id.client_item_title)
    val clientDescription = itemView.findViewById<TextView>(R.id.client_item_description)
}

class ClientAdapter(private val cursor: Cursor) : RecyclerView.Adapter<ClientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder =
        ClientViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.client_item, parent, false)
        )

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        cursor.moveToPosition(position)

        holder.clientTitle.text = cursor.getString(cursor.getColumnIndex("title"))
        holder.clientDescription.text = cursor.getString(cursor.getColumnIndex("description"))
    }

    override fun getItemCount(): Int = cursor.count

}