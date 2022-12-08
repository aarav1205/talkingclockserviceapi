package lloyds.co.uk.talkingclock.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import lloyds.co.uk.talkingclock.config.ClockConfiguration;
import lloyds.co.uk.talkingclock.model.ClockResponse;

@ExtendWith(MockitoExtension.class)
class ClockServiceTest {
	
	@Mock
	private ClockConfiguration clockconfiguration;
	
	@InjectMocks
	private ClockService clockService;

	@Test
	public void testCalculateHumanFriendlyTime_half_past() {
		ClockConfiguration clockconfig = new ClockConfiguration();
		when(clockconfiguration.numberInWordsMap()).thenReturn(clockconfig.numberInWordsMap());
		String result = clockService.calculateHumanFriendlyTime("22:30");
		assertThat("Half past Ten",is(result));
		verify(clockconfiguration).numberInWordsMap();

	}
	
	@Test
	public void testCalculateHumanFriendlyTime_quarter_past() {
		ClockConfiguration clockconfig = new ClockConfiguration();
		when(clockconfiguration.numberInWordsMap()).thenReturn(clockconfig.numberInWordsMap());
		String result = clockService.calculateHumanFriendlyTime("22:15");
		assertThat("Quarter past Ten",is(result));
		verify(clockconfiguration).numberInWordsMap();

	}
	
	@Test
	public void testCalculateHumanFriendlyTime_quarter_to() {
		ClockConfiguration clockconfig = new ClockConfiguration();
		when(clockconfiguration.numberInWordsMap()).thenReturn(clockconfig.numberInWordsMap());
		String result = clockService.calculateHumanFriendlyTime("22:45");
		assertThat("Quarter to Eleven",is(result));
		verify(clockconfiguration).numberInWordsMap();

	}
	
	@Test
	public void testCalculateHumanFriendlyTime_O_Clock() {
		ClockConfiguration clockconfig = new ClockConfiguration();
		when(clockconfiguration.numberInWordsMap()).thenReturn(clockconfig.numberInWordsMap());
		String result = clockService.calculateHumanFriendlyTime("22:00");
		assertThat("Ten O'clock",is(result));
		verify(clockconfiguration).numberInWordsMap();

	}

	@Test
	public void testValidateTime_true() {
		boolean result = clockService.ValidateTime("23:30");
		assertThat(true, is(result));
	}
	
	@Test
	public void testValidateTime_false() {
		boolean result = clockService.ValidateTime("30:30");
		assertThat(false, is(result));
	}

}
