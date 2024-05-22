package com.vivek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vivek.request.Passenger;
import com.vivek.response.Ticket;
import com.vivek.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	
	@Autowired
	MakeMyTripService service;
	
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "index";
	}
	
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute("passenger") Passenger passenger, Model model) {
		//System.out.println(passenger);
		Ticket ticket = service.bookTicket(passenger);
		model.addAttribute("msg", "Your Ticket Booked with Ticket Number: " + ticket.getTicketNumber());
		return "index";
	}
	
	@GetMapping("/ticket")
	public String loadTicketForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticket-form";
	}
	
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam Integer ticketNumber, Model model) {
		Ticket ticket = service.getTicket(ticketNumber);
		model.addAttribute("ticket", ticket);
		return "ticket-form";
	}
}
