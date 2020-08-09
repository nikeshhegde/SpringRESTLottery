package com.nikesh.lottery.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nikesh.lottery.model.LotteryTicket;
import com.nikesh.lottery.util.TicketResult;

@RestController
@RequestMapping("/lottery")
public interface LotteryController {
	
	/**
	 * Create a ticket
	 * @param lineNumbers - numbers of line to be created in the ticket
	 * @return Result with the generated ticket with no of lines
	 */
	@PostMapping("/ticket/create")
	LotteryTicket createLotteryTicket(@RequestParam(value = "lineNumbers") Integer lineNumbers);
	
	/**
	 * Return list of tickets
	 * @return List of all tickets
	 */
	@GetMapping("/ticket/read")
	List<LotteryTicket> getAllTicket();

	/**
	 * Get individual ticket
	 * @param ticketId - the ticket details for the ticketId 
	 * @return 
	 */
	@GetMapping("/ticket")
	LotteryTicket getSingleTicket(@RequestParam(value = "ticketId") Long ticketId);

	/**
	 * Amend ticket lines
	 * @param lineNumbers - numbers of line to be created in the ticket
	 * @param ticketId - the ticket id for which lines are to be amended
	 * @return the result after we amend the lines
	 */
	@PutMapping("/ticket/update")
	LotteryTicket amendTicketLine(@RequestParam(value = "lineNumbers") Integer lineNumbers,
			@RequestParam(value = "ticketId") Long ticketId);

	/**
	 * Retrieve status of ticket
	 * @param ticketId - ticketId for which the status is to be returned
	 * @return ticket details
	 */
	@PutMapping("/ticket/status")
	TicketResult retrieveTicketStatus(@RequestParam(value = "ticketId") Long ticketId);

}
