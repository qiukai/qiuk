package top.qiuk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import top.qiuk.constant.ParameterConstant;
import top.qiuk.po.Token;
import top.qiuk.po.User;
import top.qiuk.service.TokenService;
import top.qiuk.service.UserService;
import top.qiuk.util.IP;
import top.qiuk.util.MD5;
import top.qiuk.util.StringUtil;

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

	@Autowired
	TokenService tokenService;
	
	@Autowired
	RegisterController registerController;

	/**
	 * 登录
	 * 
	 * @param password
	 *            密码
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/go")
	public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam String password,
			RedirectAttributes ra) throws Exception {
		
		String email = (String) request.getSession().getAttribute(ParameterConstant.E_MAIL);
		if (StringUtil.isNull(email)) {
			ra.addFlashAttribute("error", "用户名或密码错误");
			return "redirect:/login/to";
		}
		User user = userService.login(email, password);
		if (null != user) {
			Token tokenPO = new Token(StringUtil.getUUID(), user.getId(), System.currentTimeMillis(), IP.getIP(request));
			request.setAttribute("token", tokenPO);
			tokenService.updateToken(request, response);
			return "redirect:/";
		}
		ra.addFlashAttribute("error", "用户名或密码错误");
		return "redirect:/login/to";
	}

	/**
	 * 返回秘钥
	 * 
	 * @return 经过md5的秘钥
	 */
	@ResponseBody
	@RequestMapping("/secret/{status}")
	public String getSecret(@RequestParam String email, @PathVariable String status, HttpSession session) {

		if (StringUtil.isNull(status)) {
			return "error";
		}
		User user = userService.selectByEmail(email);
		if ("login".equals(status) && null != user) {
			String secret = MD5.makeMd5(email + SECRET);
			session.setAttribute(email, secret);
			session.setAttribute(ParameterConstant.E_MAIL, email);
			return secret;
		}
		if ("register".equals(status) && null == user) {
			return MD5.makeMd5(email + SECRET);
		}
		return "error";
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
