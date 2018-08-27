package st.demo.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafApplication {

	@RequestMapping("/thymeleaf")
	public String index(Model model) {
		Person manager = new Person("Jack", 25);
		
		List<Person> staff = new ArrayList<Person>();
		Person p1 = new Person("Kelly", 30);
		Person p2 = new Person("Ken", 28);
		Person p3 = new Person("Tom", 35);
		staff.add(p1);
		staff.add(p2);
		staff.add(p3);
		
		model.addAttribute("manager", manager);
		model.addAttribute("staff", staff);
		
		return "thymeleaf/index";
	}
}
