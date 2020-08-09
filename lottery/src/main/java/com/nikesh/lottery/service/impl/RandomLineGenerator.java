package com.nikesh.lottery.service.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.nikesh.lottery.model.LotteryLine;
import com.nikesh.lottery.service.TicketLineGenerator;
import com.nikesh.lottery.util.Constants;

@Component
public class RandomLineGenerator implements TicketLineGenerator {

	private int generateRandomLotteryNumber() {
		Random rand = new Random(System.currentTimeMillis()); // instance of random class
		int upperbound = Constants.MAX_VALUE;
		int rand_number = rand.nextInt(upperbound);
		return rand_number;
	}

	@Override
	public LotteryLine generateLine() {
		return new LotteryLine(generateRandomLotteryNumber(),generateRandomLotteryNumber(),generateRandomLotteryNumber());
	}

}
