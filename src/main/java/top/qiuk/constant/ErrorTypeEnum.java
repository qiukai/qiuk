package top.qiuk.constant;

public enum ErrorTypeEnum {

	/**
	 * token 不存在
	 */
	TOKEN_IS_NULL(100, "token不合法！"),

	/**
	 * ip 错误
	 */
	IP_IS_NULL(101, "网络环境发生了变化，请登录！"),

	/**
	 * token 超时
	 */
	TOKEN_OUT_TIME(102, "请登录！");
	
	

	private String message;

	private int code;

	ErrorTypeEnum(int code, String message) {
		this.message = message;
		this.code = code;
	}

	public String getValue() {
		return message;
	}

	public int getKey() {
		return code;
	}
}
