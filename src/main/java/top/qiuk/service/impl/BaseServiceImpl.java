package top.qiuk.service.impl;

import top.qiuk.dao.BaseDao;

public class BaseServiceImpl<T, E> {

	protected BaseDao<T, E> baseDao;

	public int countByExample(E example) {
		return 0;
	}

	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	public int insert(T record) {
		return 0;
	}

	public T selectByPrimaryKey(String id) {
		return null;
	}

	public int updateByPrimaryKeySelective(T record) {
		return 0;
	}

}
