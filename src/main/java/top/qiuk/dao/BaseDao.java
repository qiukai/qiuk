package top.qiuk.dao;

import java.util.List;

public interface BaseDao<T> {

	List<T> selectList();
}
