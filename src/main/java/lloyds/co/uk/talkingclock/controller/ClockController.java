package lloyds.co.uk.talkingclock.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lloyds.co.uk.talkingclock.exceptionhandling.ClockErrorResponse;
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
	@ExceptionHandler
	public ResponseEntity<ClockErrorResponse> handleException(InvalidInputException exc) {
		ClockErrorResponse error = new ClockErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ClockErrorResponse> onException(Exception ex) {
		ClockErrorResponse error = new ClockErrorResponse();
		error.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
		error.setMessage("Internal server error. Please try again after sometime.");
		return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);


	}



}
