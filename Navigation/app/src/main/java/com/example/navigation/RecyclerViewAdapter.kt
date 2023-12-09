package com.example.navigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val data: List<EmailDataModel>,
    private val onItemClick: (EmailDataModel) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val emailSender: TextView = itemView.findViewById(R.id.emailSender)
        val emailSubject: TextView = itemView.findViewById(R.id.emailSubject)
        val emailContentPreview: TextView = itemView.findViewById(R.id.emailContentPreview)
        val emailDate: TextView = itemView.findViewById(R.id.emailDate)
        val emailProfilePic: ImageView = itemView.findViewById(R.id.emailProfilePic) 

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(data[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = data[position]
        holder.emailSender.text = email.emailSender
        holder.emailSubject.text = email.emailSubject
        holder.emailContentPreview.text = email.emailContentPreview
        holder.emailDate.text = email.emailDate
        holder.emailProfilePic.setImageResource(email.emailProfilePic)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
