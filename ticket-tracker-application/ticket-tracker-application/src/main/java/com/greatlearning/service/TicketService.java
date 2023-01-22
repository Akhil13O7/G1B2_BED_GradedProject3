package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Ticket;

public interface TicketService {

	public void addTicket(Ticket t);

	public List<Ticket> getAllTickets();

	public Ticket getTicketById(int id);

	public void delTicket(int id);

	public List<Ticket> getByKeyword(String keyword);

}
