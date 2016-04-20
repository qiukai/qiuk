package top.qiuk.service.impl;

import top.qiuk.dao.BaseDao;

public class BaseServiceImpl<T, E> {

	private BaseDao<?, ?> baseLogDao;

	public BaseDao<?, ?> getBaseLogDao() {
		return baseLogDao;
	}

	public void setBaseLogDao(BaseDao<?, ?> baseLogDao) {
		this.baseLogDao = baseLogDao;
	}
	
}
