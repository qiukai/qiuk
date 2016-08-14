package top.qiuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String toIndex() {
		return "/front/index";
	}
	
	@RequestMapping("/error404")
	public String error(){
		return "/dist/error404";
	}
}
