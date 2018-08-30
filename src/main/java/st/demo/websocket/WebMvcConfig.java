package st.demo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/websocket").setViewName("/websocket/index");
		registry.addViewController("/login").setViewName("/websocket/chat/login");
		registry.addViewController("/chat").setViewName("/websocket/chat/chat");
	}
}
