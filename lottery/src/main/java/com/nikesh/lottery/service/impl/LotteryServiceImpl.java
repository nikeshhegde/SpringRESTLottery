package com.nikesh.lottery.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nikesh.lottery.exception.CheckedTicketException;
import com.nikesh.lottery.exception.InvalidRequestException;
import com.nikesh.lottery.exception.InvalidTicket;
import com.nikesh.lottery.model.LotteryTicket;
import com.nikesh.lottery.service.LotteryController;
import com.nikesh.lottery.service.LotteryTicketRepository;
import com.nikesh.lottery.service.TicketLineGenerator;
import com.nikesh.lottery.service.TicketInterface;
import com.nikesh.lottery.util.TicketResult;

@RestController
public class LotteryServiceImpl implements LotteryController {
	
	private static final Logger LOGGER = Logger.getLogger(LotteryServiceImpl.class.getName());

	@Autowired
	TicketInterface ticketService;

	@Autowired
	LotteryTicketRepository lotteryTicketRepository;

	@Autowired
	TicketLineGenerator ticketLineGenerator;

	@Override
	public LotteryTicket createLotteryTicket(Integer lineNumbers) {
		if (lineNumbers == null || lineNumbers <= 0)
			throw new InvalidRequestException("Invalid Number of Lines! ");
		LotteryTicket lotteryTicket = ticketService.generateTicket(lineNumbers);
		lotteryTicketRepository.save(lotteryTicket);
		return lotteryTicket;
	}

	@Override
	public List<LotteryTicket> getAllTicket() {
		return (List<LotteryTicket>) lotteryTicketRepository.findAll();
	}

	@Override
	public LotteryTicket getSingleTicket(Long ticketId) {
		return lotteryTicketRepository.findById(ticketId)
				.orElseThrow(() -> new InvalidTicket("Ticket id " + ticketId.toString() + " does not exist! "));
	}

	@Override
	public LotteryTicket amendTicketLine(Integer lineNumbers, Long ticketId) {
		if (ticketId == null || ticketId <= 0)
			throw new InvalidRequestException("Invalid TicketId");
		if (lineNumbers == null || lineNumbers <= 0)
			throw new InvalidRequestException("Invalid Number of Lines");
		LotteryTicket lotteryTicket = lotteryTicketRepository.findById(ticketId).get();
		/*
		 * LOGGER.log(Level.INFO, () -> "LotteryTiket " + lotteryTicket.getId()); if
		 * (lotteryTicket == null) throw new InvalidTicket("Ticket not found");
		 */
		if (!lotteryTicket.isCheckedStatus()) {
			for (int i = 0; i < lineNumbers; i++) {
				lotteryTicket.addLine(ticketLineGenerator.generateLine());
			}
			lotteryTicketRepository.save(lotteryTicket);
		} else {
			throw new CheckedTicketException("Cannot amend the ticket");
		}
		return lotteryTicket;
	}

	@Override
	public TicketResult retrieveTicketStatus(Long ticketId) {
		if (ticketId == null || ticketId <= 0)
			throw new InvalidRequestException("Invalid TicketId");
		LotteryTicket lotteryTicket = lotteryTicketRepository.findById(ticketId).get();
		/*
		 * if (lotteryTicket == null) throw new InvalidTicket("Invalid Ticket");
		 */
		lotteryTicket.checkTicket();
		lotteryTicketRepository.save(lotteryTicket);
		TicketResult ticketResult = new TicketResult(lotteryTicket);
		return ticketResult;
	}

}
