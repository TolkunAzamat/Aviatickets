package com.example.aviatickets.admin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aviatickets.database.entities.appDatabase.App
import com.example.aviatickets.database.entities.entities.Flights
import com.example.aviatickets.databinding.ItemTimeTableBinding


class FlightAdapter: RecyclerView.Adapter<FlightAdapter.ViewHolder>() {
    private var list = mutableListOf<Flights>()

    fun setList(list: List<Flights>) {
        this.list = list.toMutableList()

    }

    class ViewHolder(val binding: ItemTimeTableBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTimeTableBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    private var onItemClickListener: ((Flights) -> Unit)? = null

    override fun onBindViewHolder(holder: FlightAdapter.ViewHolder, position: Int) {
        val current = list[position]
        holder.binding.let { ticket ->
            ticket.where.text = current.arriving
            ticket.whence.text = current.departing
            ticket.planeName.text = current.planeName
            ticket.whatTime.text = current.dateArriving.toString()
            ticket.delete.setOnClickListener {
                val db = App.instance?.getDatabase()?.Dao()
                db?.deleteCurrent(current)
                notifyItemRemoved(position)
                notifyDataSetChanged()

            }
            ticket.update.setOnClickListener {
                onItemClickListener?.let { it(current) }
            }
        }
    }

    fun onItemClickListener(listener: (Flights) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return list.size
    }
}