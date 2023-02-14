package lloyds.co.uk.talkingclock.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class ClockControllerTest {

	public static final MediaType Application_JSON = MediaType.APPLICATION_JSON;

	//@Mock
	//ClockService clockServiceMock;

	@Autowired
	private MockMvc mockMVC;

	@Test
	public void getDefaultTimeTest() throws Exception {
		mockMVC.perform( MockMvcRequestBuilders
				.get("/clock")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.value").exists());

	}
	@Test
	public void getInputQuaterPastTimeTest() throws Exception {
		String input = "12:15";
		mockMVC.perform( MockMvcRequestBuilders
				.get("/clock?time="+input)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.value").exists());
	}
	@Test
	public void getInputHalfPastTimeTest() throws Exception {
		String input = "22:30";
		mockMVC.perform( MockMvcRequestBuilders
				.get("/clock?time="+input)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.value",is("Half past Ten")));

	}
	@Test
	public void getInvalidInputTimeTest() throws Exception {
		String input = "12:1a";
		mockMVC.perform( MockMvcRequestBuilders
				.get("/clock?time="+input)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());

	}

}

