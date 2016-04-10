package top.qiuk.dao;

import java.util.List;

public interface BaseDao<T, E> {

	int countByExample(E example);

	int deleteByPrimaryKey(String id);

	int insert(T record);

	List<T> selectByExample(E example);
	
	T selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(T record);

}
