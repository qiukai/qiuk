package top.qiuk.service.impl;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.qiuk.constant.ErrorTypeEnum;
import top.qiuk.constant.ParameterConstant;
import top.qiuk.dao.TokenDao;
import top.qiuk.dao.UserDao;
import top.qiuk.exception.GlobalRuntimeException;
import top.qiuk.po.Token;
import top.qiuk.po.TokenRepository;
import top.qiuk.po.TokenRepository.Criteria;
import top.qiuk.po.User;
import top.qiuk.po.UserRepository;
import top.qiuk.service.TokenService;
import top.qiuk.util.IP;
import top.qiuk.util.ListUtil;
import top.qiuk.util.StringUtil;

@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	UserDao<User, UserRepository> userDao;

	@Autowired
	TokenDao<Token, TokenRepository> tokenDao;

	/**
	 * token 超时时间！(30天)
	 */
	private static long TOKEN_OUT_TIME = 30L * 24L * 60L * 60L * 1000L;

	@Override
	public boolean updateToken(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Token token = null;

		// 获取cookies
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {

			// 如果cookies中存在token，获取token
			if ("token".equals(cookie.getName())) {
				token = tokenDao.selectByPrimaryKey(cookie.getValue());

				// 如果没有该token
				if (null == token) {
					throw new GlobalRuntimeException(ErrorTypeEnum.TOKEN_IS_NULL);
				}

				// 如果ip不对
				if (!token.getIp().equals(IP.getIP(request))) {
					throw new GlobalRuntimeException(ErrorTypeEnum.IP_IS_NULL);
				}

				// 如果token超时
				if (System.currentTimeMillis() >= (token.getLoginTime() + TOKEN_OUT_TIME)) {
					throw new GlobalRuntimeException(ErrorTypeEnum.TOKEN_OUT_TIME);
				}

				// 修改token值，并重新保存
				token.setToken(StringUtil.getUUID());
				addToken(token);
				break;
			}
		}

		// 如果cookies中没有token
		if (null == token) {

			// 用request获取token（登录成功后，将保存token在request中）
			token = (Token) request.getAttribute("token");
			if (null == token) {
				if ("/index".equals(request.getRequestURI())) {
					return true;
				} else {
					return false;
				}
			} else {
				addToken(token);
			}
		}

		User user = userDao.selectByPrimaryKey(token.getId());
		user.setPassword(null);
		request.getSession().setAttribute(ParameterConstant.USER, user);
		request.getSession().setAttribute(ParameterConstant.IP, token.getIp());
		Cookie cookie = new Cookie("token", token.getToken());
		cookie.setPath("/index");
		cookie.setMaxAge(60*60*24*30);
		response.addCookie(cookie);
		return true;
	}

	private void addToken(Token token) {
		System.err.println(token);
		TokenRepository tokenRepository = new TokenRepository();
		Criteria criteria = tokenRepository.createCriteria();
		criteria.andIdEqualTo(token.getId());
		List<Token> list = tokenDao.selectByExample(tokenRepository);
		if (!ListUtil.isNull(list)) {
			tokenDao.deleteByPrimaryKey(list.get(0).getToken());
		}
		tokenDao.insert(token);
	}
}
