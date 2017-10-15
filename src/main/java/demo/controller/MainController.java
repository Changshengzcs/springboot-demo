package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping
	public String root() {
		// 重定向到index页面
		return "redirect:/index";
	}
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
}
