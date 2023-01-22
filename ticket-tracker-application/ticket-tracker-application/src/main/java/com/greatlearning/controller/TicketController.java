package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.entity.Ticket;
import com.greatlearning.serviceImpl.TicketServiceImpl;

@Controller
@RequestMapping("/")
public class TicketController {

	@Autowired
	private TicketServiceImpl ticketServiceImpl;

	@GetMapping("/tickets")
	public String mainPage(Model theModel) {

		List<Ticket> ticket = ticketServiceImpl.getAllTickets();
		theModel.addAttribute("ticket", ticket);
		return "index";
	}

	@GetMapping("/newTicket")
	public String newTicketPage() {
		return "newTicket";
	}

	@PostMapping("/create")
	public String createTicket(@ModelAttribute Ticket t) {

		ticketServiceImpl.addTicket(t);
		return "redirect:/tickets";

	}

	@GetMapping("/edit/{id}")
	public String editTicket(@PathVariable int id, Model themodel) {

		Ticket t = ticketServiceImpl.getTicketById(id);
		themodel.addAttribute("ticket", t);
		return "editTicket";

	}

	@PostMapping("/update")
	public String updateTicket(@ModelAttribute Ticket t) {

		ticketServiceImpl.addTicket(t);
		return "redirect:/tickets";

	}

	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable int id, Model themodel) {
		ticketServiceImpl.delTicket(id);
		return "redirect:/tickets";
	}

	@GetMapping("/view/{id}")
	public String viewTicket(@PathVariable int id, Model theModel) {

		Ticket ticket = ticketServiceImpl.getTicketById(id);
		theModel.addAttribute("ticket", ticket);
		return "viewTicket";

	}

	@PostMapping("/submit")
	public String submitTicket(@ModelAttribute Ticket t) {

		return "redirect:/tickets";

	}

	@GetMapping(path = { "/search" })
	public String home(Ticket ticket, Model model, String keyword) {
		if (keyword != null) {
			List<Ticket> ticket1 = ticketServiceImpl.getByKeyword(keyword);
			model.addAttribute("ticket", ticket1);
		} else {
			List<Ticket> list = ticketServiceImpl.getAllTickets();
			model.addAttribute("list", list);
		}
		return "index";
	}

}
