package top.qiuk.util;

import java.util.List;

public class ListUtil {

	/**
	 * 判断list是否为空
	 *
	 * @param str 目标list
	 * @return 如果字符串是空或者长度是0，强返回true否则返回false
	 */
	public static boolean isNull(List<?> list) {
		if (null == list || 0 == list.size()) {
			return true;
		}
		return false;
	}
}
