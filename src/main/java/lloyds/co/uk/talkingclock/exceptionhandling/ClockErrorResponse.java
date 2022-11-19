package lloyds.co.uk.talkingclock.exceptionhandling;

public class ClockErrorResponse {
	private int status;
	private String message;

	public ClockErrorResponse() {}

	public ClockErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}
