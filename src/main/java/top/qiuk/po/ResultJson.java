package top.qiuk.po;

import java.io.Serializable;

public class ResultJson implements Serializable {

	private static final long serialVersionUID = 1L;

	private int status;
	
	private String message;
	
	private String token;
	
	private Object object;

	public ResultJson() {
		super();
	}

	public ResultJson(int status, String message, String token, Object object) {
		super();
		this.status = status;
		this.message = message;
		this.token = token;
		this.object = object;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "ResultJson [status=" + status + ", message=" + message + ", token=" + token + ", object=" + object
				+ "]";
	}
}
