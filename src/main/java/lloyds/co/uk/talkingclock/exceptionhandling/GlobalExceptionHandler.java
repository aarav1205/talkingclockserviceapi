package lloyds.co.uk.talkingclock.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidInputException.class)
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
