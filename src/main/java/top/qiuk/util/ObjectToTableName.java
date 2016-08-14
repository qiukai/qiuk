package top.qiuk.util;

/**
 * bioa
 * @author Administrator
 *
 */
public class ObjectToTableName {
	
	/**
	 * 默认前缀
	 */
	private static final String DEFAULT_PREFIX = "log";
	
	/**
	 * 默认后缀
	 */
	private static final String DEFAULT_SUFFIX = "";

	/**
	 * 将对象转换成表明 (使用默认前缀和后缀)
	 * @param clazz 目标对象
	 * @return
	 */
	public static <T> String getTableName(Class<T> clazz){
		return getTableName(clazz, DEFAULT_PREFIX, DEFAULT_SUFFIX);
	}
	
	/**
	 * 将对象转换成表明
	 * @param clazz 目标对象
	 * @param prefix 表名前缀 如果不加请使用“”
	 * @param suffix 表名后缀 如果不加请使用“”
	 * @return
	 */
	public static <T> String getTableName(Class<T> clazz,String prefix,String suffix){
		return getTableName(clazz.getSimpleName(), prefix, suffix);
	}
	
	/**
	 * 将对象转换成表明
	 * @param objectName 类名字
	 * @param prefix 表名前缀 如果不加请使用“”
	 * @param suffix 表名后缀 如果不加请使用“”
	 * @return
	 */
	public static <T> String getTableName(String objectName ,String prefix,String suffix){
		char[] charArray = objectName.toCharArray();
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
//		User user = new User();
//		String tableName = ObjectToTableName.getTableName(user);
//		System.out.println(tableName);
	}
}
