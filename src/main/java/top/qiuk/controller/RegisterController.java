package top.qiuk.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import top.qiuk.constant.ParameterConstant;
import top.qiuk.po.User;
import top.qiuk.service.UserService;
import top.qiuk.util.StringUtil;

/**
 * 注册
 * 
 * @author 邱凯
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserService<User> userService;
	
	/**
	 * 注册
	 * @param mav
	 * @param email 邮箱
	 * @param nickName 昵称
	 * @param password 密码
	 * @return
	 */
	@RequestMapping("/go")
	public ModelAndView go(ModelAndView mav,String email,String nickName,String password) {
		User user = new User(StringUtil.getUUID(), email, nickName, password, ParameterConstant.UserStatus.NORMAL, new Date());
		userService.insert(user);
		mav.setViewName("redirect:/");
		return mav;
	}

	/**
	 * 去注册页面
	 * @return
	 */
	@RequestMapping("/to")
	public String toRegister() {
		return "/front/register";
	}
}
