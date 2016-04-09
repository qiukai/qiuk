package top.qiuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import top.qiuk.po.User;
import top.qiuk.service.UserService;

/**
 * 登录
 * @author 邱凯
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	/**
	 * 密码盐，userName+secrect  进行MD5    生成盐；
	 * password + 盐   进行MD5 保存数据库
	 */
	private static final String SECRECT = "0987654321!@#$%^&*()qiuk!@#$%^&*()0987654321";
	
	@Autowired
	UserService<User> userService;
	
	@RequestMapping("/login/{userName}/{password}")
	public String login(@PathVariable String userName, @PathVariable String password) {
		return null;
	}
	
	/**
	 * 返回秘钥
	 * @return
	 */
	@RequestMapping("/secrect/{userName}")
	public String getSecrect(@PathVariable String userName) {
		return SECRECT;
	}
	
	/**
	 * 去登录页面
	 * @return
	 */
	@RequestMapping("/to")
	public String toLogin() {
		return "/front/login";
	}
}
