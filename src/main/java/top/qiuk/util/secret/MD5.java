package top.qiuk.util.secret;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5的算法在RFC1321 中定义 在RFC 1321中，给出了Test suite用来检验你的实现是否正确： MD5 ("") =
 * d41d8cd98f00b204e9800998ecf8427e MD5 ("a") = 0cc175b9c0f1b6a831c399e269772661
 * MD5 ("abc") = 900150983cd24fb0d6963f7d28e17f72 MD5 ("message digest") =
 * f96b697d7cb7938d525a2f31aaf161d0 MD5 ("abcdefghijklmnopqrstuvwxyz") =
 * c3fcd3d76192e4007dfb496cca67e13b
 *
 * @author haogj
 *
 *         传入参数：一个字节数组 传出参数：字节数组的 MD5 结果字符串
 */
public final class MD5 {

	public static String getMD5(byte[] source) {
		String s = null;
		// 用来将字节转换成 16 进制表示的字符
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source);

			// MD5 的计算结果是一个 128 位的长整数
			byte tmp[] = md.digest();

			// 用字节表示就是 16 个字节
			// 每个字节用 16 进制表示的话，使用两个字符
			// 所以表示成 16 进制需要 32 个字符
			char str[] = new char[16 * 2];

			// 表示转换结果中对应的字符位置
			int k = 0;

			// 从第一个字节开始，对 MD5 的每一个字节 转换成 16 进制字符的转换
			for (int i = 0; i < 16; i++) {
				// 取第 i 个字节
				byte byte0 = tmp[i];
				// 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				// 取字节中低 4 位的数字转换
				str[k++] = hexDigits[byte0 & 0xf];
			}
			// 换后的结果转换为字符串
			s = new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}

	/**
	 * 获取给定字符串的 MD5 值。
	 *
	 * @param in
	 *            要进行 MD5 加密的字符串
	 * @return
	 */
	public static String makeMd5(String in) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.reset();
			digest.update(in.getBytes());
			byte[] a = digest.digest();
			int len = a.length;
			StringBuilder sb = new StringBuilder(len << 1);
			for (int i = 0; i < len; i++) {
				sb.append(Character.forDigit((a[i] & 0xf0) >> 4, 16));
				sb.append(Character.forDigit(a[i] & 0x0f, 16));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getMD5(String raw) {
		if (raw == null || raw.length() == 0) {
			return "";
		}
		try {
			return getMD5(raw.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) {
		String md5 = getMD5("123456");
		System.out.println(md5);
	}
}
