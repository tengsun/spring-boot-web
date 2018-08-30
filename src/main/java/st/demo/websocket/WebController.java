package st.demo.websocket;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {

	@Autowired
	private SimpMessagingTemplate msgTemplate;

	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WebResponse sayHello(WebMessage message) throws InterruptedException {
		Thread.sleep(1000);
		return new WebResponse("Welcome, " + message.getName() + "!");
	}

	@MessageMapping("/chat")
	public void handleChat(Principal principal, String msg) {
		if (principal.getName().equals("jack")) {
			msgTemplate.convertAndSendToUser("kate", "/queue/notice", principal.getName() + " says " + msg);
		} else {
			msgTemplate.convertAndSendToUser("jack", "/queue/notice", principal.getName() + " says " + msg);
		}
	}
}
