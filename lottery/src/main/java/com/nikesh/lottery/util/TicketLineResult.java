package com.nikesh.lottery.util;

import com.nikesh.lottery.model.LotteryLine;

public class TicketLineResult {

	private LotteryLine lotteryLine;
	private Integer lotteryLineValue;

	public TicketLineResult(LotteryLine line) {
		lotteryLine = line;
		lotteryLineValue = lotteryLine.checkResultOfLine();
	}

	public LotteryLine getLotteryLine() {
		return lotteryLine;
	}

	public Integer getLotteryLineValue() {
		return lotteryLineValue;
	}

	/**
	 * Return according to the highest value
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static int compare(TicketLineResult o1, TicketLineResult o2) {
		return o1.lotteryLineValue - o2.getLotteryLineValue();
	}
}
