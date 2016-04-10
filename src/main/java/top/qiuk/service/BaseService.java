package top.qiuk.service;

public interface BaseService<T> {

	int deleteByPrimaryKey(String id);

	int insert(T record);

	T selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(T record);
}
