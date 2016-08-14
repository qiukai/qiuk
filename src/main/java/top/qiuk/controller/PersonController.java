package top.qiuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/person")
public class PersonController {

	@RequestMapping(method=RequestMethod.GET)
	public String to(){
		return "/front/person";
	}
	
}
