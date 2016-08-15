package com.mystery.refl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Date;

import org.junit.Test;

/**
 * java 反射机制测试类
 * @author ChengFan
 *
 */
public class TestReflect {
	@Test
	public void test1() {
		Person p = new Person();// 暂时先这样写，下面的代码会使用反射的方法来创建对象
		String className = p.getClass().getName();
		System.out.println(className);
	}

	@Test
	public void test2() {
		Class<?> test1 = null;
		Class<?> test2 = null;
		Class<?> test3 = null;

		try {
			test1 = Class.forName("com.mystery.refl.Person");
			// 一般都会用这种方式
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		test2 = new Person().getClass();
		test3 = Person.class;

		System.out.println("类名   " + test1.getName());
		System.out.println("类名   " + test2.getName());
		System.out.println("类名   " + test3.getName());
	}

	@Test
	public void test3() {
		Class<?> test = null;

		try {
			test = Class.forName("com.mystery.refl.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 取得本类的全部属性
		Field[] field = test.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			// 权限修饰符
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
			// 属性类型
			Class<?> type = field[i].getType();
			System.out.println(priv + " " + type.getName() + " "
					+ field[i].getName() + ";");
		}
	}

	@Test
	public void test4() {
		Class<?> test = null;

		try {
			test = Class.forName("com.mystery.refl.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 调用Person类中的sayChina方法
			Method method = test.getMethod("sayChina");
			method.invoke(test.newInstance());
			// 调用Person的sayHello方法
			method = test.getMethod("sayHello", String.class, int.class);
			method.invoke(test.newInstance(), "jack", 21);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test5() {
		Class<?> test = null;

		try {
			test = Class.forName("com.mystery.refl.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 获得类所实现的接口
		Class<?> intes[] = test.getInterfaces();
		for (int i = 0; i < intes.length; i++) {
			System.out.println("实现的接口   " + intes[i].getName());
		}

		// 获得类所继承的父类
		Class<?> temp = test.getSuperclass();
		System.out.println("继承的父类为：   " + temp.getName());

		// 获得类中所有的构造函数
		Constructor<?> cons[] = test.getConstructors();
		for (int i = 0; i < cons.length; i++) {
			System.out.println("构造方法：  " + cons[i]);
		}

	}

	@SuppressWarnings("deprecation")
	@Test
	public void test6() {
		Class<?> test = null;

		try {
			test = Class.forName("com.mystery.refl.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Person per = null;
		try {
			per = (Person) test.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		per.setName("jack");
		per.setBirthday(new Date(95, 11, 27));
		;
		System.out.println(per);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test7() {
		Person p = new Person();
		p.setAge(20);
		p.setBirthday(new Date(95, 11, 27));
		p.setName("jack");

		Field[] fields = p.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			try {
				Object value =  f.get(p);
				if (value != null) {
					f.set(p, deal(value));
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(p);
		System.out.println(p.getAge());
	}

	@SuppressWarnings("deprecation")
	private Object deal(Object value) {
		if (value instanceof Integer) {
			return 50;
		} else if (value instanceof String) {
			return "tom";
		} else if (value instanceof Date) {
			return new Date(1,1,1);
		}
		return value;
	}

}
