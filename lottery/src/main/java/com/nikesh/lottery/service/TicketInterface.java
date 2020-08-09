package com.nikesh.lottery.service;

import com.nikesh.lottery.model.LotteryTicket;

public interface TicketInterface {
    LotteryTicket generateTicket(int numLines);
}
