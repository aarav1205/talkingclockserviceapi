package lloyds.co.uk.talkingclock.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClockConfiguration {
	
	@Bean
	public Map<Integer,String> hourMap(){
		
		Map<Integer,String> hourmap = new HashMap<Integer,String>();
		hourmap.put(1, "One");
		hourmap.put(2, "Two");
		hourmap.put(3, "Three");
		hourmap.put(4, "Four");
		hourmap.put(5, "Five");
		hourmap.put(6, "Six");
		hourmap.put(7, "Seven");
		hourmap.put(8, "Eight");
		hourmap.put(9, "Nine");
		hourmap.put(10, "Ten");
		hourmap.put(11, "Eleven");
		hourmap.put(12, "Twelve");
		
		return hourmap;
		
	}
	
	@Bean
	public Map<Integer,String> minuteMap(){
		
		Map<Integer,String> minutemap = new HashMap<Integer,String>();
		minutemap.put(1, "One");
		minutemap.put(2, "Two");
		minutemap.put(3, "Three");
		minutemap.put(4, "Four");
		minutemap.put(5, "Five");
		minutemap.put(6, "Six");
		minutemap.put(7, "Seven");
		minutemap.put(8, "Eight");
		minutemap.put(9, "Nine");
		minutemap.put(10, "Ten");
		minutemap.put(11, "Eleven");
		minutemap.put(12, "Twelve");
		minutemap.put(13, "Three");
		minutemap.put(14, "Fourteen");
		minutemap.put(15, "Fifteen");
		minutemap.put(16, "Sixteen");
		minutemap.put(17, "Seventeen");
		minutemap.put(18, "Eighteen");
		minutemap.put(19, "Ninteen");
		minutemap.put(20, "Twenty");
		minutemap.put(21, "Twenty One");
		minutemap.put(22, "Twenty Two");
		minutemap.put(23, "Twenty Three");
		minutemap.put(24, "Twenty Four");
		minutemap.put(25, "Twenty Five");
		minutemap.put(26, "Twenty Six");
		minutemap.put(27, "Twenty Seven");
		minutemap.put(28, "Twenty Eight");
		minutemap.put(29, "Twenty Nine");
		minutemap.put(30, "Thirty");
		
		return minutemap;
		
	}

}
