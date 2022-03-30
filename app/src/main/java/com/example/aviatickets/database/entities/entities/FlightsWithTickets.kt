package com.example.aviatickets.database.entities.entities

import androidx.room.Embedded
import androidx.room.Relation

data class FlightsWithTickets (
    @Embedded
    val flights:Flights,
    @Relation(
        parentColumn ="idFlights",
        entityColumn = "idTicket"
    )
    val tickets:List<Tickets>
        )