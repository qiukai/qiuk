package top.qiuk.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import top.qiuk.util.ObjectToTableName;
import top.qiuk.util.StringUtil;

/**
 * Created by 邱凯 on 2016/4/10.
 */
@Component
@Aspect
public class Log {

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
	public void save(JoinPoint joinPoint) throws Exception {
		Object[] objects = joinPoint.getArgs();

		Class<? extends Object> class1 = objects[0].getClass();
		String name = class1.getName();
		Class<?> class2 = Class.forName(name + "Log");
		System.out.println(class2.getName());
		Object object = class2.newInstance();

		Field[] fields = class1.getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			if ("id".equals(field.getName())) {
				Method method = class2.getMethod("setPrimaryId", String.class);
				method.invoke(object, field.get(objects[0]));
			} else if ("serialVersionUID".equals(field.getName())) {
				continue;
			} else {
				String name2 = field.getName();
				String substring = name2.substring(1);
				String upperCase = name2.substring(0, 1).toUpperCase();
				Method method = class2.getMethod("set" + upperCase + substring,field.getType());
				method.invoke(object, field.get(objects[0]));
			}
		}
		System.out.println(object);
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
