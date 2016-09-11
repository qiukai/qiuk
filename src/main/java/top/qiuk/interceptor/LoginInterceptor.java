package top.qiuk.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import top.qiuk.constant.ErrorTypeEnum;
import top.qiuk.constant.ParameterConstant;
import top.qiuk.exception.GlobalRuntimeException;
import top.qiuk.po.User;
import top.qiuk.service.TokenService;
import top.qiuk.util.IP;
import top.qiuk.util.PropertiesUtil;
import top.qiuk.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * 
 * @author Administrator
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String[] ignore = PropertiesUtil.getPropertyValue("config", "IGNORE.URI").split(",");
	@Autowired
	TokenService tokenService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {


		String requestURI = request.getRequestURI();
		for (String uri : ignore) {
			if (requestURI.contains(uri)) {
				return true;
			}
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(ParameterConstant.USER);
		if ((null == user || StringUtil.isNull(user.getId())) && tokenService.updateToken(request, response)) {
			return true;
		}
		if (!IP.getIP(request).equals(session.getAttribute(ParameterConstant.IP))) {
			throw new GlobalRuntimeException(ErrorTypeEnum.IP_IS_NULL);
		}
		return true;
	}
}
