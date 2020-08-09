package com.nikesh.lottery.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nikesh.lottery.model.LotteryLine;
import com.nikesh.lottery.model.LotteryTicket;
import com.nikesh.lottery.service.TicketLineGenerator;
import com.nikesh.lottery.service.TicketInterface;

@Component
public class TicketInterfaceImpl implements TicketInterface {
	
	@Autowired
	TicketLineGenerator ticketLineGenerator;
	
	@Override
	public LotteryTicket generateTicket(int numLines) {
        List<LotteryLine> lines = new ArrayList<LotteryLine>(numLines);
        for(int i=0;i<numLines;i++){
            lines.add(ticketLineGenerator.generateLine());
        }
        return new LotteryTicket(lines);
	}

}
