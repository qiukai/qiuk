package top.qiuk.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.qiuk.dao.UserDao;
import top.qiuk.po.UserRepository;
import top.qiuk.service.UserService;
import top.qiuk.util.ListUtil;

@Service
public class UserServiceImpl<T> extends BaseServiceImpl<T,UserRepository> implements UserService<T> {

	@Autowired
	UserDao<T,UserRepository> userDao;
	
	@PostConstruct
	public void setBaseDao(){
		baseDao = userDao;
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

}
