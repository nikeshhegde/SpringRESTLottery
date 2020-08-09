package com.nikesh.lottery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class LotteryLine {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lotteryLineId;
    
    private int[] lineNumbers = new int[3];
    
	@Version
	private long version = 0L;
    
    public LotteryLine(){}

    public LotteryLine(int num1,int num2,int num3){
        lineNumbers[0] = num1;
        lineNumbers[1] = num2;
        lineNumbers[2] = num3;
    }

    /**
     * Returns the array of numbers in the line
     * @return
     */
    public int[] getLineNumbers() {
        return lineNumbers;
    }

    /**
     * Returns the value of the given line as per the specification below
     * You have a series of lines on a ticket with 3 numbers, each of which has a value of 0, 1, or
		2. For each ticket if the sum of the values on a line is 2, the result for that line is 10.
		Otherwise if they are all the same, the result is 5. Otherwise so long as both 2nd and 3rd
		numbers are different from the 1st, the result is 1. Otherwise the result is 0.
     * @return
     */
    public int checkResultOfLine(){
        int result = 0;
        if(lineNumbers[0]+lineNumbers[1]+lineNumbers[2]==2){
            result = 10;
        }else if(lineNumbers[0]==lineNumbers[1] && lineNumbers[1]==lineNumbers[2]){
            result = 5;
        }else if(lineNumbers[0]!=lineNumbers[1] && lineNumbers[0] != lineNumbers[2]){
            result = 1;
        }
        return result;
    }
}
