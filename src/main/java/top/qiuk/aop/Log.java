package top.qiuk.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import top.qiuk.constant.LogTypeEnum;
import top.qiuk.constant.ParameterConstant;
import top.qiuk.dao.BaseDao;
import top.qiuk.po.User;
import top.qiuk.service.impl.BaseServiceImpl;
import top.qiuk.util.StringUtil;

/**
 * Created by 邱凯 on 2016/4/10.
 */
@Component
@Aspect
public class Log {

	private static final String User = null;

	@Pointcut("@annotation(top.qiuk.aop.SaveLog)")
	public void save() {
	}

	@Pointcut("@annotation(top.qiuk.aop.UpdateLog)")
	public void update() {
	}

	@Pointcut("@annotation(top.qiuk.aop.DeleteLog)")
	public void delete() {
	}

	@Before("save()")
	public void insert(JoinPoint joinPoint) throws Exception {
		Object[] objects = joinPoint.getArgs();
		Class<? extends Object> class1 = objects[0].getClass();
		String name = class1.getName();
		Class<?> class2 = Class.forName(name + "Log");
		Object object = class2.newInstance();
		Field[] fields = class1.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if ("id".equals(field.getName())) {
				Method method = class2.getMethod("setPrimaryId", String.class);
				method.invoke(object, field.get(objects[0]));
				continue;
			}
			if ("serialVersionUID".equals(field.getName())) {
				continue;
			}
			String name2 = field.getName();
			String substring = name2.substring(1);
			String upperCase = name2.substring(0, 1).toUpperCase();
			Method method = class2.getMethod("set" + upperCase + substring, field.getType());
			method.invoke(object, field.get(objects[0]));
		}
		Class<? extends Object> class3 = object.getClass();
		
		class3.getMethod("setId", String.class).invoke(object, StringUtil.getUUID());
		class3.getMethod("setLogType", Integer.class).invoke(object, LogTypeEnum.INSERT.getValue());
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(ParameterConstant.USER);
		if (null != user) {
			class3.getMethod("setLogId", String.class).invoke(object, user.getId());
		} else {
			class3.getMethod("setLogId", String.class).invoke(object, "");
		}
		
		BaseServiceImpl<?,?> baseServiceImpl = (BaseServiceImpl<?,?>) joinPoint.getTarget();
		BaseDao<?, ?> baseLogDao = baseServiceImpl.getBaseLogDao();
		baseLogDao.insert(object);
	}

	@Before("update()")
	public void update(JoinPoint joinPoint) {
		System.out.println("hello");
	}

	@Before("delete()")
	public void delete(JoinPoint joinPoint) {
		System.out.println("hello");
	}
}
