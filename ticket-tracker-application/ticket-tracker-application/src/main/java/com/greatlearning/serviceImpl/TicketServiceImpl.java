package com.greatlearning.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.Ticket;
import com.greatlearning.repository.TicketRepository;
import com.greatlearning.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public void addTicket(Ticket t) {

		ticketRepository.save(t);
	}

	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	public Ticket getTicketById(int id) {

		Optional<Ticket> t = ticketRepository.findById(id);
		if (t.isPresent()) {
			return t.get();
		}
		return null;

	}

	public void delTicket(int id) {

		ticketRepository.deleteById(id);
	}

	public List<Ticket> getByKeyword(String keyword) {
		return ticketRepository.findByKeyword(keyword);
	}

}
