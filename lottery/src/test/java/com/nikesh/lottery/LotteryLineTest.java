package com.nikesh.lottery;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.nikesh.lottery.model.LotteryLine;

public class LotteryLineTest {

	private class LineTest {
		int lineNumber1;
		int lineNumber2;
		int lineNumber3;
	}
	
	/**
	 * give all combinations of the result = 10
	 * @throws Exception
	 */
	@Test
	public void testCheckLineEqualsTen() throws Exception {
		ArrayList<LineTest> lineTests = new ArrayList<LineTest>(6);
		LineTest lineNumberTest = new LineTest();
		lineNumberTest.lineNumber1 = 1;
		lineNumberTest.lineNumber2 = 1;
		lineNumberTest.lineNumber3 = 0;
		lineTests.add(lineNumberTest);
		lineNumberTest = new LineTest();
		lineNumberTest.lineNumber1 = 1;
		lineNumberTest.lineNumber2 = 0;
		lineNumberTest.lineNumber3 = 1;
		lineTests.add(lineNumberTest);
		lineNumberTest = new LineTest();
		lineNumberTest.lineNumber1 = 0;
		lineNumberTest.lineNumber2 = 1;
		lineNumberTest.lineNumber3 = 1;
		lineTests.add(lineNumberTest);
		lineNumberTest = new LineTest();
		lineNumberTest.lineNumber1 = 2;
		lineNumberTest.lineNumber2 = 0;
		lineNumberTest.lineNumber3 = 0;
		lineTests.add(lineNumberTest);
		lineNumberTest = new LineTest();
		lineNumberTest.lineNumber1 = 0;
		lineNumberTest.lineNumber2 = 2;
		lineNumberTest.lineNumber3 = 0;
		lineTests.add(lineNumberTest);
		lineNumberTest = new LineTest();
		lineNumberTest.lineNumber1 = 0;
		lineNumberTest.lineNumber2 = 0;
		lineNumberTest.lineNumber3 = 2;
		lineTests.add(lineNumberTest);

		for (LineTest test : lineTests) {
			LotteryLine lotteryLine = new LotteryLine(test.lineNumber1, test.lineNumber2, test.lineNumber3);
			assertEquals(lotteryLine.checkResultOfLine(), 10);
		}
	}

	/**
	 * give all combinations of the result = 5
	 * @throws Exception
	 */
	@Test
	public void testCheckLineAllSameEqualsFive() throws Exception {
		ArrayList<LineTest> lineTests = new ArrayList<LineTest>(6);
		LineTest lineTest = new LineTest();
		lineTest.lineNumber1 = 1;
		lineTest.lineNumber2 = 1;
		lineTest.lineNumber3 = 1;
		lineTests.add(lineTest);
		lineTest = new LineTest();
		lineTest.lineNumber1 = 0;
		lineTest.lineNumber2 = 0;
		lineTest.lineNumber3 = 0;
		lineTests.add(lineTest);
		lineTest = new LineTest();
		lineTest.lineNumber1 = 2;
		lineTest.lineNumber2 = 2;
		lineTest.lineNumber3 = 2;
		lineTests.add(lineTest);

		for (LineTest test : lineTests) {
			LotteryLine lotteryLine = new LotteryLine(test.lineNumber1, test.lineNumber2, test.lineNumber3);
			assertEquals(lotteryLine.checkResultOfLine(), 5);
		}
	}
	
	/**
	 * give all combinations of the result = 1
	 * @throws Exception
	 */
	@Test
	public void testCheckLineSecondThirdDiffersFromOneEqualsOne() throws Exception {
		ArrayList<LineTest> lineTests = new ArrayList<LineTest>(6);
		LineTest lineTest = new LineTest();
		lineTest.lineNumber1 = 1;
		lineTest.lineNumber2 = 2;
		lineTest.lineNumber3 = 2;
		lineTests.add(lineTest);
		lineTest = new LineTest();
		lineTest.lineNumber1 = 1;
		lineTest.lineNumber2 = 0;
		lineTest.lineNumber3 = 2;
		lineTests.add(lineTest);
		lineTest = new LineTest();
		lineTest.lineNumber1 = 0;
		lineTest.lineNumber2 = 1;
		lineTest.lineNumber3 = 2;
		lineTests.add(lineTest);
		lineTest = new LineTest();
		lineTest.lineNumber1 = 2;
		lineTest.lineNumber2 = 1;
		lineTest.lineNumber3 = 1;
		lineTests.add(lineTest);
		lineTest = new LineTest();
		lineTest.lineNumber1 = 2;
		lineTest.lineNumber2 = 0;
		lineTest.lineNumber3 = 1;
		lineTests.add(lineTest);

		for (LineTest test : lineTests) {
			LotteryLine lotteryLine = new LotteryLine(test.lineNumber1, test.lineNumber2, test.lineNumber3);
			assertEquals(lotteryLine.checkResultOfLine(), 1);
		}
	}
	
	/**
	 * give all combinations of the result = 0
	 * @throws Exception
	 */
	@Test
	public void testCheckLineEqualsZero() throws Exception {
		ArrayList<LineTest> lineTests = new ArrayList<LineTest>(6);
		LineTest lineTest = new LineTest();
		lineTest.lineNumber1 = 1;
		lineTest.lineNumber2 = 1;
		lineTest.lineNumber3 = 2;
		lineTests.add(lineTest);
		lineTest = new LineTest();
		lineTest.lineNumber1 = 1;
		lineTest.lineNumber2 = 2;
		lineTest.lineNumber3 = 1;
		lineTests.add(lineTest);
		lineTest = new LineTest();
		lineTest.lineNumber1 = 0;
		lineTest.lineNumber2 = 1;
		lineTest.lineNumber3 = 0;
		lineTests.add(lineTest);
		lineTest = new LineTest();
		lineTest.lineNumber1 = 2;
		lineTest.lineNumber2 = 1;
		lineTest.lineNumber3 = 2;
		lineTests.add(lineTest);
		lineTest = new LineTest();
		lineTest.lineNumber1 = 2;
		lineTest.lineNumber2 = 2;
		lineTest.lineNumber3 = 1;
		lineTests.add(lineTest);

		for (LineTest test : lineTests) {
			LotteryLine lotteryLine = new LotteryLine(test.lineNumber1, test.lineNumber2, test.lineNumber3);
			assertEquals(lotteryLine.checkResultOfLine(), 0);
		}
	}
}
