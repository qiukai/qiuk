package top.qiuk.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import top.qiuk.constant.ExceptionTypeEnum;
import top.qiuk.exception.UtilRuntimeException;

public class HttpClientUtil {

	enum HttpMothod {
		GET, POST, DOWNLOAD;
	}

	private static Logger logger = Logger.getLogger(HttpClientUtil.class);

	private static int outTime = 1800000;// 30分钟（http连接超时）
	private static int reqTime = 5000;// 1分钟（请求超时）

	private String encoding;
	private String url;
	private Map<String, String> para = null;
	private HttpClient httpClient;
	private Cookie[] cookie;

	public HttpClientUtil(String url) {
		this(url, null);
	}

	public HttpClientUtil(String url, Map<String, String> para) {
		this(url, "utf-8", para);
	}

	public HttpClientUtil(String url, String encoding, Map<String, String> para) {
		if (StringUtil.isNull(url)) {
			throw new UtilRuntimeException(ExceptionTypeEnum.STRING_IS_NULL, "url为空");
		}
		if (null == encoding) {
			encoding = "utf-8";
		}
		this.url = url;
		this.encoding = encoding;
		this.para = para;
		this.httpClient = new HttpClient();
		this.httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(outTime);
		this.httpClient.getState().addCookies(cookie);
	}

	public String execute(HttpMothod mothod) {
		return execute(mothod, null);
	}

	public String execute(HttpMothod mothod, String fileName) {
		logger.info("请求的url为:" + url);
		HttpMethod httpMethod = getHttpMethod(mothod);
		String value = null;
		try {
			this.httpClient.executeMethod(httpMethod);
			int state = httpMethod.getStatusCode();
			if (state == 200) {
				cookie = httpClient.getState().getCookies();
				value = this.readInputStream(mothod, httpMethod.getResponseBodyAsStream(), fileName);
				// logger.info(value);
			} else {
				logger.error(state);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpMethod.releaseConnection();
		}
		return value;
	}

	private String readInputStream(HttpMothod mothod, InputStream inputStream, String fileName) throws Exception {

		byte[] b = new byte[1024];
		int readBytes = 0;
		StringBuilder sb = new StringBuilder();
		FileOutputStream fileOutputStream = null;

		switch (mothod) {
		case GET:
		case POST:
			while ((readBytes = inputStream.read(b)) > 0) {
				sb.append(new String(b, 0, readBytes, encoding));
			}
			break;
		default:
			if (StringUtil.isNull(fileName)) {
				throw new UtilRuntimeException(ExceptionTypeEnum.FILE_NAME_NULL, "文件名不可以为空");
			}
			fileOutputStream = new FileOutputStream(fileName);
			while ((readBytes = inputStream.read(b)) != -1) {
				fileOutputStream.write(b, 0, readBytes);
			}
			sb.append("文件下载成功");
		}

		if (null != inputStream) {
			inputStream.close();
			inputStream = null;
		}
		if (null != fileOutputStream) {
			fileOutputStream.close();
			fileOutputStream = null;
		}

		return sb.toString();
	}

	private HttpMethod getHttpMethod(HttpMothod mothod) {
		HttpMethod httpMethod = null;
		switch (mothod) {
		case GET:
		case DOWNLOAD:
			httpMethod = new GetMethod(url);
			break;
		default:
			httpMethod = new PostMethod(url);
			if (null != para && 0 != para.size()) {
				NameValuePair[] nameValuePairs = new NameValuePair[para.size()];
				int i = 0;
				for (String key : para.keySet()) {
					if (null != para.get(key)) {
						nameValuePairs[i] = new NameValuePair(key, para.get(key).toString());
						i++;
					}
				}
				((PostMethod) httpMethod).setRequestBody(nameValuePairs);
			}
			break;
		}
		httpMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, reqTime);
		httpMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, encoding);
		return httpMethod;
	}

	public static void saveImageByURL(String url, File imageName) throws Exception {
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		HttpMethod httpMethod = new GetMethod(url);
		HttpClient client = new HttpClient();
		httpMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 600000);
		client.executeMethod(httpMethod);
		int state = httpMethod.getStatusCode();
		if (state == 200) {
			inputStream = httpMethod.getResponseBodyAsStream();
		}
		
		if (inputStream == null) {
			return;
		} else {
			
		}
		
		byte[] data = new byte[1024];
		int len = 0;
		fileOutputStream = new FileOutputStream(imageName);
		while ((len = inputStream.read(data)) != -1) {
			fileOutputStream.write(data, 0, len);

		}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
			}
		}
		if (fileOutputStream != null) {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
			}
		}
		httpMethod.releaseConnection();
	}

	
	public static void saveImageByURL123(String url, long l) throws Exception {
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		HttpMethod httpMethod = new GetMethod(url);
		HttpClient client = new HttpClient();
		httpMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 600000);
		client.executeMethod(httpMethod);
		int state = httpMethod.getStatusCode();
		if (state == 200) {
			inputStream = httpMethod.getResponseBodyAsStream();
		} else {
			return;
		}
		File imageName = null;
		if (inputStream == null) {
			return;
		} else {
			imageName = new File("D:\\aa\\"+l+".pdf");
		}
		
		byte[] data = new byte[1024];
		int len = 0;
		fileOutputStream = new FileOutputStream(imageName);
		while ((len = inputStream.read(data)) != -1) {
			fileOutputStream.write(data, 0, len);

		}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
			}
		}
		if (fileOutputStream != null) {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
			}
		}
		httpMethod.releaseConnection();
	}
	
	public static void main(String[] args) {
//		long time = 130412093921164L;
//		String string = "http://hbj.nantong.gov.cn/attach/0/"+time+".pdf";
		long time = 140413093921164L;
//		              130412093946298L
		for (long i = 130412093946462L; i < (130412093946462L+(60*60*1000)); i++) {
			String string = "http://hbj.nantong.gov.cn/attach/0/"+i+".pdf";
			try {
				HttpClientUtil.saveImageByURL123(string, i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(i+"L");
			}
			System.out.println(i+"L");
//			new Thread(new A(i,0)).start();
//			if (i % 100 == 0) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}

		// String[] split = execute.split("\\$");
		//
		// for (int i = 0; i < split.length; i++) {
		// logger.info("$$$"+i+"::"+split[i]);
		// String[] split2 = split[i].split(";");
		// for (int j = 0; j < split2.length; j++) {
		// logger.info("\t;;;--"+i+"--::"+split2[j]);
		// }
		// }

	}
}

class A implements Runnable{

	private long a;
	private long b;
	
	public A(long a,long b) {
		this.a = a;
		this.b = b;
	}
	
	public void run() {
		String string = "http://hbj.nantong.gov.cn/attach/0/"+a+".pdf";
		try {
			HttpClientUtil.saveImageByURL123(string, a);
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println(a);
		}
		
	}
	
}
