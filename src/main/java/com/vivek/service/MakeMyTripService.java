package com.vivek.service;

import com.vivek.request.Passenger;
import com.vivek.response.Ticket;

public interface MakeMyTripService {
	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNumber);
}
