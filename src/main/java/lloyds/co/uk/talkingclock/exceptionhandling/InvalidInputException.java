package lloyds.co.uk.talkingclock.exceptionhandling;

@SuppressWarnings("serial")
public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }

}

