package lloyds.co.uk.talkingclock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lloyds.co.uk.talkingclock.config.ClockConfiguration;

@Service
public class ClockService {

	@Autowired
	private ClockConfiguration clockconfiguration;

	public String calculateHumanFriendlyTime(String numericTime) {

		//numericTime expected value HH:MM
		String humanFriendlyTime = null;
		String hh =numericTime.split(":")[0];
		String mm =numericTime.split(":")[1];
		if(Integer.parseInt(hh)>=0 && Integer.parseInt(hh)<24 && Integer.parseInt(mm)==00) {
			if(Integer.parseInt(hh)==0 || Integer.parseInt(hh)==12) {
				humanFriendlyTime =  clockconfiguration.hourMap().get(12) + " o'clock";
			}else {
				humanFriendlyTime =  clockconfiguration.hourMap().get(Integer.parseInt(hh)%12) + " o'clock";
			}
		}else if(Integer.parseInt(hh)>=0 && Integer.parseInt(hh)<24 && Integer.parseInt(mm)==15)
		{
			if(Integer.parseInt(hh)==0 || Integer.parseInt(hh)==12) {
				humanFriendlyTime =  "Quarter past "+clockconfiguration.hourMap().get(12);
			}else {
				humanFriendlyTime =  "Quarter past "+clockconfiguration.hourMap().get(Integer.parseInt(hh)%12);
			}

		}
		else if(Integer.parseInt(hh)>=0 && Integer.parseInt(hh)<24 && Integer.parseInt(mm)==30)
		{
			if(Integer.parseInt(hh)==0 || Integer.parseInt(hh)==12) {
				humanFriendlyTime =  "Half past "+clockconfiguration.hourMap().get(12);
			}else {
				humanFriendlyTime =  "Half past "+clockconfiguration.hourMap().get(Integer.parseInt(hh)%12);
			}
		}
		else if(Integer.parseInt(hh)>=0 && Integer.parseInt(hh)<24 && Integer.parseInt(mm)==45)
		{
			if(Integer.parseInt(hh)==0 || Integer.parseInt(hh)==12) {
				humanFriendlyTime =  "Quarter to "+clockconfiguration.hourMap().get(1);
			}else {
				humanFriendlyTime =  "Quarter to "+clockconfiguration.hourMap().get((Integer.parseInt(hh)%12)+1);
			}

		}else if(Integer.parseInt(hh)>=0 && Integer.parseInt(hh)<24 && Integer.parseInt(mm)<60)
		{
			if(Integer.parseInt(hh)==0 || Integer.parseInt(hh)==12) {
				if(Integer.parseInt(mm)<30) {
					humanFriendlyTime =  clockconfiguration.hourMap().get(12)+" past "+clockconfiguration.minuteMap().get(Integer.parseInt(mm));
				}
				else {
					humanFriendlyTime =  clockconfiguration.minuteMap().get(60-Integer.parseInt(mm))+" to "+clockconfiguration.hourMap().get(1);
				}
			}else {
				if(Integer.parseInt(mm)<30) {
					humanFriendlyTime =  clockconfiguration.hourMap().get(Integer.parseInt(hh)%12)
							+" past "+clockconfiguration.minuteMap().get(Integer.parseInt(mm));
				}
				else {
					humanFriendlyTime =  clockconfiguration.minuteMap().get(60-Integer.parseInt(mm))
							+" to "+clockconfiguration.hourMap().get((Integer.parseInt(hh)%12)+1);
				}
			}

		}


		return humanFriendlyTime;

	}
	public boolean ValidateTime(String timeparam) {

		try {
			String hh =timeparam.split(":")[0];
			String mm =timeparam.split(":")[1];
			if(timeparam==null || timeparam.length()!=5 || hh==null || mm==null) {
				return false;
			}
			else if(Integer.parseInt(hh)>=0 
					&& Integer.parseInt(hh)<24 
					&& Integer.parseInt(mm)>=0 
					&& Integer.parseInt(mm)<60)
			{
				return true;
			}
		}
	/*	catch(NumberFormatException e)
		{
			return false;
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			return false;
		} */
		catch(Exception e)
		{
			return false;
		}

		return false;
	}

}
