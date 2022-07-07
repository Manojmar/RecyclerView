package com.example.task2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class Adapter(var cont: Context, private val list: ArrayList<Model>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        var title: TextView =v.findViewById(R.id.text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.activity_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val out = list[position]
        holder.title.text = out.name.toString()
        holder.itemView.setBackgroundColor(ContextCompat.getColor(cont, out.color))

        holder.itemView.setOnClickListener {

            Toast.makeText(holder.itemView.context, position.toString(), Toast.LENGTH_SHORT).show()

        }
    }
    override fun getItemCount(): Int {
        return list.size
    }
}