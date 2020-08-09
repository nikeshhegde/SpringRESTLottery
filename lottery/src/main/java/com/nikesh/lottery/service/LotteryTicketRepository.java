package com.nikesh.lottery.service;

import org.springframework.data.repository.CrudRepository;

import com.nikesh.lottery.model.LotteryTicket;

public interface LotteryTicketRepository extends CrudRepository<LotteryTicket, Long> {

}
