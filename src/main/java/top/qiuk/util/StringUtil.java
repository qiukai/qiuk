package top.qiuk.util;

import java.util.UUID;

/**
 * Created by Administrator on 2015/12/19. String的帮助类
 */
public class StringUtil {

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str 目标字符串
	 * @return 如果字符串是空或者长度是0，强返回true否则返回false
	 */
	public static boolean isNull(String str) {
		return getLength(str) == 0 ? true : false;
	}

	/**
	 * 返回String的长度，
	 * 
	 * @param str
	 *            目标字符串
	 * @return 如果str是空将返回为0，否则返回长度
	 */
	public static int getLength(String str) {
		return str == null ? 0 : str.length();
	}

	/**
	 * 生成随机的UUID（该uuid可以作为id使用）
	 *
	 * @return String类型
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
