package lloyds.co.uk.talkingclock.controller;

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
import org.springframework.boot.test.context.SpringBootTest;

import lloyds.co.uk.talkingclock.exceptionhandling.InvalidInputException;
import lloyds.co.uk.talkingclock.model.ClockResponse;
import lloyds.co.uk.talkingclock.service.ClockService;


@SpringBootTest
public class ClockControllerTest {

	@Mock
	private ClockService clockServiceMock;
	
	@InjectMocks
	private ClockController clockController;

	@Test
	public void test_getTime_withParam() {
		
		when(clockServiceMock.calculateHumanFriendlyTime("22:30")).thenReturn("Half past Ten");
		when(clockServiceMock.ValidateTime("22:30")).thenReturn(true);
		ClockResponse result = clockController.getTime(Optional.of("22:30"));
		assertThat("Half past Ten",is(result.getValue()));
		verify(clockServiceMock).calculateHumanFriendlyTime(Mockito.anyString());
		verify(clockServiceMock).ValidateTime(Mockito.anyString());

	}
	
	@Test
	public void test_getTime_Exception() {
		
		when(clockServiceMock.calculateHumanFriendlyTime(Mockito.anyString())).thenReturn("");
		when(clockServiceMock.ValidateTime(Mockito.anyString())).thenReturn(false);
		
		assertThrows(InvalidInputException.class, ()->{
			clockController.getTime(Optional.of("70:80"));
		});

	}

}

