package top.qiuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注册
 * 
 * @author 邱凯
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

	@RequestMapping("to")
	public String toRegister() {
		return "/front/register";
	}
}
