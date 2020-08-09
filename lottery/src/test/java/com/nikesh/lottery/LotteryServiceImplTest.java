package com.nikesh.lottery;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nikesh.lottery.exception.InvalidRequestException;
import com.nikesh.lottery.exception.InvalidTicket;
import com.nikesh.lottery.model.LotteryLine;
import com.nikesh.lottery.model.LotteryTicket;
import com.nikesh.lottery.service.LotteryTicketRepository;
import com.nikesh.lottery.service.TicketInterface;
import com.nikesh.lottery.service.TicketLineGenerator;
import com.nikesh.lottery.service.impl.LotteryServiceImpl;
import com.nikesh.lottery.util.Constants;
import com.nikesh.lottery.util.TicketResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LotteryApplication.class)
@WebAppConfiguration
public class LotteryServiceImplTest {

	@Mock
	private TicketInterface ticketService;

	@Mock
	private LotteryTicketRepository lotteryTicketRepository;

	@Mock
	private TicketLineGenerator ticketLineGenerator;

	@InjectMocks
	private LotteryServiceImpl lotteryService;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	public void setup() {
		Random random = new Random(System.currentTimeMillis());
		ArrayList<LotteryLine> lotteryLines = new ArrayList<LotteryLine>(1);
		lotteryLines.add(new LotteryLine(1, 1, 1));
		LotteryTicket lotteryTicket1 = new LotteryTicket(lotteryLines);
		LotteryTicket lotteryTicketDb = new LotteryTicket(1);
		lotteryTicket1.getLines().stream().forEach(l -> lotteryTicketDb.addLine(l));
		when(ticketService.generateTicket(anyInt())).thenReturn(lotteryTicket1);
		when(ticketLineGenerator.generateLine()).thenReturn(new LotteryLine(random.nextInt(Constants.MAX_VALUE),
				random.nextInt(Constants.MAX_VALUE), random.nextInt(Constants.MAX_VALUE)));
		when(lotteryTicketRepository.findById(1L)).thenReturn(Optional.of(lotteryTicketDb));
	}

	@Test
	public void testCreateLotteryTicket() throws Exception {
		setup();
		LotteryTicket lotteryTicket = lotteryService.createLotteryTicket(1);
		assertNotNull(lotteryTicket);
		assertNotNull(lotteryTicket.getLines());
		assertTrue(lotteryTicket.getLines().size() == 1);
	}

	@Test
	public void testAddLineToTicket() throws Exception {
		setup();
		LotteryTicket lotteryTicket = lotteryService.createLotteryTicket(1);
		assertNotNull(lotteryTicket);
		assertNotNull(lotteryTicket.getLines());
		assertTrue(lotteryTicket.getLines().size() == 1);
		LotteryTicket amendedTicket = lotteryService.amendTicketLine(5, 1L);
		assertNotNull(amendedTicket);
		assertNotNull(amendedTicket.getLines());
		assertTrue(amendedTicket.getLines().size() == 6);
	}

	@Test
	public void testRetrieveTicketStatus() throws Exception {
		setup();
		LotteryTicket lotteryTicket = lotteryService.createLotteryTicket(2);
		assertNotNull(lotteryTicket);
		assertNotNull(lotteryTicket.getLines());
		assertTrue(lotteryTicket.getLines().size() == 1);
		TicketResult ticketResult = lotteryService.retrieveTicketStatus(1L);
		assertNotNull(ticketResult);
		assertNotNull(ticketResult.getResults());
		assertTrue(ticketResult.getResults().size() == 1);
		assertTrue(ticketResult.getResults().get(0).getLotteryLineValue() == 5);
	}

	@Test(expected = InvalidRequestException.class)
	public void amendTicketLineExpectionInvalidTicketIdNegNum() {
		setup();
		lotteryService.amendTicketLine(-1, 10L);
	}

	@Test(expected = InvalidRequestException.class)
	public void amendTicketLineExpectionInvalidTicketIdZero() {
		setup();
		lotteryService.retrieveTicketStatus(0L);
	}

	@Test(expected = InvalidRequestException.class)
	public void retrieveTicketStatusExpectionInvalidTicketIdNegNum() {
		setup();
		lotteryService.retrieveTicketStatus(-1L);
	}

	@Test(expected = InvalidRequestException.class)
	public void retrieveTicketStatusExpectionInvalidTicketIdZero() {
		setup();
		lotteryService.retrieveTicketStatus(0L);
	}

	/*
	 * @Test(expected = InvalidTicket.class) public void
	 * amendTicketLineExpectExpectionTicketNotFound() { setup();
	 * lotteryService.amendTicketLine(1, 10L); }
	 * 
	 * @Test(expected = InvalidTicket.class) public void
	 * retrieveTicketStatusExpectionTicketNotFound() { setup();
	 * lotteryService.retrieveTicketStatus(5L); }
	 */
}
