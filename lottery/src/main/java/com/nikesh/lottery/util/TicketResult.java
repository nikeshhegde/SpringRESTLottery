package com.nikesh.lottery.util;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import com.nikesh.lottery.model.LotteryLine;
import com.nikesh.lottery.model.LotteryTicket;

public class TicketResult {

	private List<TicketLineResult> results = new ArrayList<TicketLineResult>();
	private LotteryTicket ticket;

	public TicketResult(LotteryTicket ticket) {
		for (LotteryLine lotteryLine : ticket.getLines()) {
			results.add(new TicketLineResult(lotteryLine));
		}
		this.ticket = ticket;
	}
	
	public List<TicketLineResult> getResults() {
        return results.stream().sorted((o1, o2) -> TicketLineResult.compare(o2, o1)).collect(toList());
    }
}
