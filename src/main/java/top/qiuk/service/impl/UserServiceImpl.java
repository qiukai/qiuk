package top.qiuk.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.qiuk.dao.UserDao;
import top.qiuk.service.UserService;

@Service
public class UserServiceImpl<T> extends BaseServiceImpl<T> implements UserService<T> {

	@Autowired
	UserDao<T> userDao;
	
	@PostConstruct
	public void setBaseDao(){
		baseDao = userDao;
	}
}
