package top.qiuk.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.qiuk.dao.UserDao;
import top.qiuk.dao.UserLogDao;
import top.qiuk.po.UserLog;
import top.qiuk.po.UserLogRepository;
import top.qiuk.po.UserRepository;
import top.qiuk.service.UserService;
import top.qiuk.util.ListUtil;

@Service
public class UserServiceImpl<T> extends BaseServiceImpl<T,UserRepository> implements UserService<T> {

	@Autowired
	UserDao<T,UserRepository> userDao;
	
	@Autowired
	UserLogDao<UserLog,UserLogRepository> userLogDao;
	
	@PostConstruct
	public void setBaseDao(){
		baseDao = userDao;
		setBaseLogDao(userLogDao);
	}
	
	@Override
	public T selectByEmail(String email) {
		
		UserRepository userRepository = new UserRepository();
		userRepository.createCriteria().andEmailEqualTo(email);
		List<T> list = userDao.selectByExample(userRepository);
		if (ListUtil.isNull(list)) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public T login(String email, String password) {
		UserRepository userRepository = new UserRepository();
		userRepository.or().andEmailEqualTo(email).andPasswordEqualTo(password);
		List<T> list = userDao.selectByExample(userRepository);
		if (ListUtil.isNull(list)) {
			return null;
		}
		return list.get(0);
	}

}
