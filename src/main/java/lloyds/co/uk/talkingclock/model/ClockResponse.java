package lloyds.co.uk.talkingclock.model;
public class ClockResponse {


	private String value;

	public ClockResponse(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
