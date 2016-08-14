package top.qiuk.util;

import java.io.IOException;
import java.util.ResourceBundle;

import top.qiuk.constant.ExceptionTypeEnum;
import top.qiuk.exception.UtilRuntimeException;

public class PropertiesUtil {

	/**
	 * 获取属性文件中属性的值
	 * 
	 * @param propertyName
	 *            属性文件名
	 * @param key
	 *            属性名称
	 * @return
	 */
	public static String getPropertyValue(String propertyName, String key) {

		ResourceBundle resourceBundle = null;
		try {
			resourceBundle = ResourceBundle.getBundle(propertyName);
		} catch (Exception e) {
			throw new UtilRuntimeException(ExceptionTypeEnum.FILE_NAME, "文件为：" + propertyName);
		}

		try {
			String value = resourceBundle.getString(key);
			return value == null ? null : new String(value.getBytes("ISO8859-1"), "utf-8");
		} catch (IOException e) {
			throw new UtilRuntimeException(ExceptionTypeEnum.KEY_IS_NULL, "key为：" + key);
		}
	}
}
