package edu.bdqn.ssm.util;

import java.io.InputStream;
import java.util.Properties;

/*注意final修饰的类不能被继承、修饰的变量的值不能被修改、修饰的方法不能被重写
 *静态的方法直接通过类名称调用
 *要读取配置文件需要该类继承Properties
 *而Properties是继承 HashTable的固操作的时候按照键取值
 */

@SuppressWarnings("serial")
public final class Env extends Properties {

	private static Env instance;

	/**
	 * 与单例模式创建、获的对象实例
	 * 
	 * @return 返回已经创建好Env对象
	 */
	public static Env getInstance() {
		if (instance != null) {
			return instance;
		} else {
			makeInstance();
			return instance;
		}
	}

	/**
	 * 同步方法，保证在同一时间，只能被一个人调用
	 */
	private static synchronized void makeInstance() {
		if (instance == null) {
			instance = new Env();
		}
	}

	/**
	 * 构造函数执行判断配置文件是否存在
	 */
	private Env() {
		InputStream is = getClass().getResourceAsStream("/pager.properties");
		try {
			load(is);
		} catch (Exception e) {
			System.err.println("错误：没有读取属性文件，请确认pager.properties文件是否存在。");
			return;
		}
	}
}
