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

	@PostMapping("/ticket/create")
	LotteryTicket createLotteryTicket(@RequestParam(value = "lineNumbers") Integer lineNumbers);

	@GetMapping("/ticket/read")
	List<LotteryTicket> getAllTicket();

	@GetMapping("/ticket")
	LotteryTicket getSingleTicket(@RequestParam(value = "ticketId") Long ticketId);

	@PutMapping("/ticket/update")
	LotteryTicket amendTicketLine(@RequestParam(value = "lineNumbers") Integer lineNumbers,
			@RequestParam(value = "ticketId") Long ticketId);

	@PutMapping("/ticket/status")
	TicketResult retrieveTicketStatus(@RequestParam(value = "ticketId") Long ticketId);

}
