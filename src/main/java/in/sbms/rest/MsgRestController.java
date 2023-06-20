package in.sbms.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping("/greet")
	public String greetMsg()
	{
		return "good morning";
	}
	
	@GetMapping("/welcome")
	public String welcomeMsg()
	{
		return "welcome to Bihar";
	}
	
	

	@GetMapping("/contact")
	public String contactMsg()
	{
		return "contact me +91 8406968023";
	}

}
