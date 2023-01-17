package com.greatlearning.tickettrackingapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tickettrackingapp.entity.Ticket;
import com.greatlearning.tickettrackingapp.repo.TicketRepo;
import com.greatlearning.tickettrackingapp.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	// autowiring the ticketrepo class
	@Autowired
	private TicketRepo ticketRepo;

	// creating ticket function
	public void addTicket(Ticket t) {

		ticketRepo.save(t);
	}

	// reading tickets
	public List<Ticket> getAllTickets() {
		return ticketRepo.findAll();
	}

	// finding ticket by id to edit and update ticket
	public Ticket getTicketById(int id) {

		Optional<Ticket> t = ticketRepo.findById(id);
		if (t.isPresent()) {
			return t.get();
		}
		return null;

	}

	// delete function
	public void delTicket(int id) {

		ticketRepo.deleteById(id);
	}

	// search function
	public List<Ticket> getByKeyword(String keyword) {
		return ticketRepo.findByKeyword(keyword);
	}

}
