package top.qiuk.service.impl;

import top.qiuk.aop.DeleteLog;
import top.qiuk.aop.SaveLog;
import top.qiuk.aop.UpdateLog;
import top.qiuk.dao.BaseDao;

public class BaseServiceImpl<T, E> {

	protected BaseDao<T, E> baseDao;

	public int countByExample(E example) {
		return 0;
	}

	@DeleteLog
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	@SaveLog
	public int insert(T record) {
		
		System.out.println(record);
		
		return 0;
	}

	public T selectByPrimaryKey(String id) {
		return null;
	}

	@UpdateLog
	public int updateByPrimaryKeySelective(T record) {
		return 0;
	}

}
