package top.qiuk.service;

public interface UserService<T> extends BaseService<T> {

	T selectByEmail(String email);
}
