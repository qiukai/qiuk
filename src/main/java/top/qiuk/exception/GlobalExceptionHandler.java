package top.qiuk.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler
	public String ServiceExceptionHandler(Exception ex) {
		if (ex instanceof GlobalRuntimeException) {
			GlobalRuntimeException gre = (GlobalRuntimeException) ex;
			logger.error("自定义异常：code：" + gre.getCode() + "\n描述：" + gre.getMessage() + "\n异常信息：" + ex.getMessage() + "\n堆栈信息：" + ex.getStackTrace());
			ex.printStackTrace();
		} else {
			logger.error("未知异常:\n异常信息：" + ex.getMessage() + "\n堆栈信息：" + ex.getStackTrace() +" | "+ ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		return "error/error500";
	}
}
