package lloyds.co.uk.talkingclock.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lloyds.co.uk.talkingclock.exceptionhandling.InvalidInputException;
import lloyds.co.uk.talkingclock.model.ClockResponse;
import lloyds.co.uk.talkingclock.service.ClockService;



@RestController
public class ClockController {
	@Autowired
	private ClockService clockservice; 


	@GetMapping(value = "/clock")
	public ClockResponse getTime(@RequestParam Optional<String> time) {

		ClockResponse clockResponse;
		String timeparam =time.orElse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
		boolean isValidTime = clockservice.ValidateTime(timeparam);
		

		if (isValidTime) {
			clockResponse = new ClockResponse(clockservice.calculateHumanFriendlyTime(timeparam));
			return clockResponse;
		}
		else {
			throw new InvalidInputException("Invalid Input.");
		}

	}
	


}
