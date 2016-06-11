package top.qiuk.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler
	public ModelAndView ServiceExceptionHandler(Exception ex) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error/error500");
		modelAndView.addObject("error", "出错了！");
		if (ex instanceof GlobalRuntimeException) {
			GlobalRuntimeException gre = (GlobalRuntimeException) ex;
			logger.error("自定义异常：code：" + gre.getCode() + "\n描述：" + gre.getMessage() + "\n异常信息：" + ex.getMessage()
					+ "\n堆栈信息：" + ex.getStackTrace(), ex);
			modelAndView.addObject("message", gre.getMessage());
		} else if (ex instanceof UtilRuntimeException) {
			UtilRuntimeException gre = (UtilRuntimeException) ex;
			logger.error("自定义异常：code：" + gre.getCode() + "\n描述：" + gre.getMessage() + "\n异常信息：" + ex.getMessage()
					+ "\n堆栈信息：" + ex.getStackTrace(), ex);
			ex.printStackTrace();
		} else {
			logger.error("未知异常:\n异常信息：" + ex.getMessage() + "\n堆栈信息：" + ex.getStackTrace() + " | "
					+ ex.getLocalizedMessage(), ex);
			ex.printStackTrace();
		}
		return modelAndView;
	}
}
