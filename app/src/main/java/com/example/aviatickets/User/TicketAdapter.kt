package com.example.aviatickets.User

/*import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aviatickets.admin.adapter.FlightAdapter
import com.example.aviatickets.database.entities.appDatabase.App
import com.example.aviatickets.database.entities.entities.Flights
import com.example.aviatickets.database.entities.entities.Tickets
import com.example.aviatickets.databinding.ItemTimeTableBinding

class TicketAdapter:RecyclerView.Adapter<TicketAdapter.ViewHolder>() {
    private var list = mutableListOf<Tickets>()
    fun setList(list: List<Tickets>) {
    this.list = list.toMutableList()
}

class ViewHolder(val binding: ItemTimeTableBinding) : RecyclerView.ViewHolder(binding.root)

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketAdapter.ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = ItemTimeTableBinding.inflate(inflater, parent, false)
    return ViewHolder(binding)
}

private var onItemClickListener: ((Tickets) -> Unit)? = null

override fun onBindViewHolder(holder: TicketAdapter.ViewHolder, position: Int) {
    val current = list[position]
    holder.binding.let { ticket ->
       // ticket.whence.text = current.
        ticket.where.text = current.
        ticket.planeName.text = current.planeName
        ticket.whatTime.text = current.dateArriving.toString()


    }
}

fun onItemClickListener(listener: (Tickets) -> Unit) {
    onItemClickListener = listener
}

override fun getItemCount(): Int {
    return list.size
}
}*/