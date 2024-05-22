package com.vivek.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.vivek.request.Passenger;
import com.vivek.response.Ticket;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {
	
	private String BOOK_TICKET_URL = "http://localhost:8081/book-ticket";
	private String GET_TICKET_URL = "http://localhost:8081/get-ticket/{num}/data";

	@Override
	public Ticket bookTicket(Passenger passenger) {
//		RestTemplate rt = new RestTemplate();
//		ResponseEntity<Ticket> responseEntity = rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
//		Ticket ticket = responseEntity.getBody();
		
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.post()
				 .uri(BOOK_TICKET_URL)
		         .bodyValue(passenger)
		         .retrieve()
		         .bodyToMono(Ticket.class)
		         .block();
		
		
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
//		RestTemplate rt = new RestTemplate();
//		ResponseEntity<Ticket> responseEntity = rt.getForEntity(GET_TICKET_URL, Ticket.class, ticketNumber);
//		Ticket ticket = responseEntity.getBody();
		
		
        WebClient webClient = WebClient.create();
		
		Ticket ticket = webClient.get()
				 .uri(GET_TICKET_URL, ticketNumber)
				 .retrieve()
				 .bodyToMono(Ticket.class)
				 .block();  //sync call
		
		return ticket;
	}

}
