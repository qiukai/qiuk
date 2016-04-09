package top.qiuk.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	List<T> selectList(Map<String, Object> map);
}
