package lloyds.co.uk.talkingclock.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClockConfiguration {
	
	private final String[] number_in_words = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine", "Ten", "Eleven", "Twelve", "Three",
			"Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen", "Twenty", "Twenty One", "Twenty Two", "Twenty Three", "Twenty Four", 
			"Twenty Five", "Twenty Six", "Twenty Seven", "Twenty Eight", "Twenty Nine", "Thirty"};
	
	@Bean
	public Map<Integer,String> numberInWordsMap(){

		Map<Integer,String> numberinwordsmap = new HashMap<Integer,String>();
		for(int i=1;i<=30;i++) {
			numberinwordsmap.put(i,number_in_words[i]);
		}

		return numberinwordsmap;

	}
	
	

}


