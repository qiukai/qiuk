package top.qiuk.service.impl;

import java.util.HashMap;
import java.util.Map;

import qk.util.db.ObjectToTableName;
import top.qiuk.dao.BaseDao;

public class BaseServiceImpl<T> {
	
	protected BaseDao<T> baseDao;
	
	protected static final String TABLE_NAME = "tableName";
	
	protected Map<String, Object> params = new HashMap<String, Object>();
	
	protected Map<String, Object> getParamsMap(T t){
		params.put(TABLE_NAME, ObjectToTableName.getTableName(t.getClass()));
		return params;
	}
	
	public void save(T t) {
		System.out.println("111");
		baseDao.selectList(null);
		
	}
}
