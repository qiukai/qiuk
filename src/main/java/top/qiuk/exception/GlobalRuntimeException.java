package top.qiuk.exception;

import top.qiuk.constant.ExceptionTypeEnum;

/**
 * 帮助类运行时异常
 * 
 * @author Administrator
 *
 */
public class GlobalRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int code;

	private String message;

	/**
	 * @param exceptionTypeEnum
	 *            错误类型
	 */
	public GlobalRuntimeException(ExceptionTypeEnum exceptionTypeEnum) {
		code = exceptionTypeEnum.getKey();
		message = exceptionTypeEnum.getValue();
	}

	/**
	 * 
	 * @param exceptionTypeEnum 错误类型
	 * @param errorDescription 错误描述
	 */
	public GlobalRuntimeException(ExceptionTypeEnum exceptionTypeEnum, String errorDescription) {
		code = exceptionTypeEnum.getKey();
		message = exceptionTypeEnum.getValue() + ":" + errorDescription;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GlobalRuntimeException [code=" + code + ", message=" + message + "]";
	}
}
