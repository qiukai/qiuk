package top.qiuk.exception;

import top.qiuk.constant.ExceptionTypeEnum;

/**
 * 帮助类运行时异常
 * 
 * @author Administrator
 *
 */
public class UtilRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int code;

	private String message;

	public UtilRuntimeException(ExceptionTypeEnum exceptionTypeEnum) {
		code = exceptionTypeEnum.getKey();
		message = exceptionTypeEnum.getValue();
	}

	public UtilRuntimeException(ExceptionTypeEnum exceptionTypeEnum, String string) {
		code = exceptionTypeEnum.getKey();
		message = exceptionTypeEnum.getValue() + ":" + string;
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
}
