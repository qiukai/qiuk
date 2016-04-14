package top.qiuk.constant;

import top.qiuk.exception.UtilRuntimeException;

public enum ExceptionTypeEnum {

	EXCEPTION_TYPE_ENUM("异常类型枚举异常", 0), DATE("日期错误", 1), FILE_NAME("文件不存在", 2), DATE_FORMATTER("日期格式错误", 3);

	private String message;

	private int code;

	ExceptionTypeEnum(String message, int code) {
		this.message = message;
		this.code = code;
	}
	
	ExceptionTypeEnum() {
	}

	public String getValue() {
		return message;
	}

	public int getKey() {
		return code;
	}
	
	public static String getValue(int key) {
		for (ExceptionTypeEnum ete : ExceptionTypeEnum.values()) {
			if (key == ete.getKey()) {
				return ete.getValue();
			}
		}
		throw new UtilRuntimeException(ExceptionTypeEnum.EXCEPTION_TYPE_ENUM);
	}

	public static int getKey(String value) {
		for (ExceptionTypeEnum ete : ExceptionTypeEnum.values()) {
			if (ete.getValue().contains(value)) {
				return ete.getKey();
			}
		}
		throw new UtilRuntimeException(ExceptionTypeEnum.EXCEPTION_TYPE_ENUM);
	}

	public String toString() {
		return this.code + ":" + this.message;
	}
}