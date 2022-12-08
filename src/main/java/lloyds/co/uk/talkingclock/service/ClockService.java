package lloyds.co.uk.talkingclock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lloyds.co.uk.talkingclock.config.ClockConfiguration;

@Service
public class ClockService {

	@Autowired
	private ClockConfiguration clockconfiguration;

	private final String string_colon_splitter=":";
	private final String string_Oclock=" O'clock";
	private final String string_QuaterPast_clock="Quarter past ";
	private final String string_HalfPast_clock="Half past ";
	private final String string_QuaterTo_clock="Quarter to ";
	private final String string_Past_clock=" past ";
	private final String string_To_clock=" to ";



	public String calculateHumanFriendlyTime(String numericTime) {

		//numericTime expected value HH:MM
		String humanFriendlyTime = null;
		int hh =Integer.parseInt(numericTime.split(string_colon_splitter)[0]);
		int mm =Integer.parseInt(numericTime.split(string_colon_splitter)[1]);
		if(hh>=0 && hh<24 && mm==00) {
			if(hh==0 || hh==12) {
				humanFriendlyTime =  clockconfiguration.numberInWordsMap().get(12) + string_Oclock;
			}else {
				humanFriendlyTime =  clockconfiguration.numberInWordsMap().get(hh%12) + string_Oclock;
			}
		}else if(hh>=0 && hh<24 && mm==15)
		{
			if(hh==0 || hh==12) {
				humanFriendlyTime =  string_QuaterPast_clock+clockconfiguration.numberInWordsMap().get(12);
			}else {
				humanFriendlyTime =  string_QuaterPast_clock+clockconfiguration.numberInWordsMap().get(hh%12);
			}

		}
		else if(hh>=0 && hh<24 && mm==30)
		{
			if(hh==0 || hh==12) {
				humanFriendlyTime =  string_HalfPast_clock+clockconfiguration.numberInWordsMap().get(12);
			}else {
				humanFriendlyTime =  string_HalfPast_clock+clockconfiguration.numberInWordsMap().get(hh%12);
			}
		}
		else if(hh>=0 && hh<24 && mm==45)
		{
			if(hh==0 || hh==12) {
				humanFriendlyTime =  string_QuaterTo_clock+clockconfiguration.numberInWordsMap().get(1);
			}else {
				humanFriendlyTime =  string_QuaterTo_clock+clockconfiguration.numberInWordsMap().get((hh%12)+1);
			}

		}else if(hh>=0 && hh<24 && mm<60)
		{
			if(hh==0 || hh==12) {
				if(mm<30) {
					humanFriendlyTime =  clockconfiguration.numberInWordsMap().get(12)+string_Past_clock+clockconfiguration.numberInWordsMap().get(mm);
				}
				else {
					humanFriendlyTime =  clockconfiguration.numberInWordsMap().get(60-mm)+string_To_clock+clockconfiguration.numberInWordsMap().get(1);
				}
			}else {
				if(mm<30) {
					humanFriendlyTime =  clockconfiguration.numberInWordsMap().get(hh%12)
							+string_Past_clock+clockconfiguration.numberInWordsMap().get(mm);
				}
				else {
					humanFriendlyTime =  clockconfiguration.numberInWordsMap().get(60-mm)
							+string_To_clock+clockconfiguration.numberInWordsMap().get((hh%12)+1);
				}
			}

		}


		return humanFriendlyTime;

	}
	public boolean ValidateTime(String timeparam) {
 
		try {
			int hh =Integer.parseInt(timeparam.split(string_colon_splitter)[0]);
			int mm =Integer.parseInt(timeparam.split(string_colon_splitter)[1]);
			if(timeparam==null || timeparam.length()!=5) {
				return false;
			}
			else if(hh>=0 && hh<24 && mm>=0 && mm<60)
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
