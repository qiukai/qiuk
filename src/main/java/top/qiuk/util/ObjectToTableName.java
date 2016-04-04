package top.qiuk.util;

import top.qiuk.po.User;

public class ObjectToTableName {
	
	/**
	 * 默认前缀
	 */
	private static final String DEFAULT_PREFIX = "t";
	
	/**
	 * 默认后缀
	 */
	private static final String DEFAULT_SUFFIX = "";

	/**
	 * 将对象转换成表明 (使用默认前缀和后缀)
	 * @param o 目标对象
	 * @return
	 */
	public static String getTableName(Object o){
		return getTableName(o, DEFAULT_PREFIX, DEFAULT_SUFFIX);
	}
	
	/**
	 * 将对象转换成表明
	 * @param o 目标对象
	 * @param prefix 表名前缀 如果不加请使用“”
	 * @param suffix 表名后缀 如果不加请使用“”
	 * @return
	 */
	public static String getTableName(Object o,String prefix,String suffix){
		String simpleName = o.getClass().getSimpleName();
		char[] charArray = simpleName.toCharArray();
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		for (char c : charArray) {
			if (('A' <= c) && (c <= 'Z')) {
				sb.append('_');
				c = (char) (c + 32);
			}
			sb.append(c);
		}
		sb.append(suffix);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		User user = new User();
		String tableName = ObjectToTableName.getTableName(user);
		System.out.println(tableName);
	}
}
