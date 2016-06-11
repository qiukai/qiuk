package top.qiuk.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TokenService {
	
	/**
	 * 验证token
	 * @param request
	 * @param response
	 * @return
	 */
	void updateToken(HttpServletRequest request,HttpServletResponse response);
}
