package top.qiuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.qiuk.po.User;
import top.qiuk.service.UserService;
import top.qiuk.util.StringUtil;
import top.qiuk.util.secret.MD5;

/**
 * 登录
 * 
 * @author 邱凯
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	/**
	 * 密码盐，userName+secrect 进行MD5 生成盐； password + 盐 进行MD5 保存数据库
	 */
	private static final String SECRET = "0987654321!@#$%^&*()qiuk!@#$%^&*()0987654321";

	@Autowired
	UserService<User> userService;

	@RequestMapping("/login/{userName}/{password}")
	public String login(@PathVariable String userName, @PathVariable String password) {
		return null;
	}

	/**
	 * 返回秘钥
	 * 
	 * @return 经过md5的秘钥
	 */
	@ResponseBody
	@RequestMapping("/secret/{status}")
	public String getSecret(@RequestParam String email, @PathVariable String status) {

		if (StringUtil.isNull(status)) {
			return "error";
		}
		User user = userService.selectByEmail(email);
		if ("login".equals(status) && null != user) {
			return MD5.makeMd5(email + SECRET);
		}
		if ("register".equals(status) && null == user) {
			return MD5.makeMd5(email + SECRET);
		}
		return "errorMessage";
	}

	/**
	 * 去登录页面
	 * 
	 * @return 登录页面的路径
	 */
	@RequestMapping("/to")
	public String toLogin() {
		return "/front/login";
	}
}
