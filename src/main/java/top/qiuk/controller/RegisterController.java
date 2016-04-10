package top.qiuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注册
 * 
 * @author 邱凯
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@RequestMapping("/go")
	public ModelAndView go(ModelAndView mav,String email,String nickName,String password) {
		return mav;
	}

	@RequestMapping("/to")
	public String toRegister() {
		return "/front/register";
	}
}
