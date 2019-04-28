package top.ljjapp.utils;

/**
 * UUID帮助类
 * @author lijiajun
 */
public class UUID {

	public static String randomUUID() {
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}
}
