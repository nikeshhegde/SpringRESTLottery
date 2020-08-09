package com.nikesh.lottery.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class LotteryTicket {

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<LotteryLine> lines;

	private boolean checkedStatus = false;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Version
	private long version = 0L;

	public LotteryTicket() {
	}

	public LotteryTicket(long id) {
		this.id = id;
	}

	public LotteryTicket(List<LotteryLine> lines) {
		this.lines = lines;
	}

	/**
	 * Used to add a line to the lottery ticket
	 * 
	 * @param line
	 */
	public void addLine(LotteryLine line) {
		if (lines == null) {
			this.lines = new ArrayList<LotteryLine>();
		}
		this.lines.add(line);
	}

	public List<LotteryLine> getLines() {
		return lines;
	}

	public boolean isCheckedStatus() {
		return checkedStatus;
	}

	public long getId() {
		return id;
	}
	
	public void checkTicket(){
	 checkedStatus = true;
    }

}
