package top.qiuk.service.impl;

import top.qiuk.aop.DeleteLog;
import top.qiuk.aop.SaveLog;
import top.qiuk.aop.UpdateLog;
import top.qiuk.dao.BaseDao;

public class BaseServiceImpl<T, E> {

	protected BaseDao<T, E> baseDao;
	
	private BaseDao<?, ?> baseLogDao;

	public int countByExample(E example) {
		return 0;
	}

	@DeleteLog
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	@SaveLog
	public int insert(T record) {
		baseDao.insert(record);
		return 1;
	}

	public T selectByPrimaryKey(String id) {
		return null;
	}

	@UpdateLog
	public int updateByPrimaryKeySelective(T record) {
		return 0;
	}

	public BaseDao<?, ?> getBaseLogDao() {
		return baseLogDao;
	}

	public void setBaseLogDao(BaseDao<?, ?> baseLogDao) {
		this.baseLogDao = baseLogDao;
	}

}
