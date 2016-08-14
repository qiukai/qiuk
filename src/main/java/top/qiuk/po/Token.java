package top.qiuk.po;

import java.io.Serializable;

public class Token implements Serializable{
	private static final long serialVersionUID = 1L;

	private String token;

    private String id;

    private Long loginTime;

    private String ip;

    public Token() {
		super();
	}

	public Token(String token, String id, Long loginTime, String ip) {
		super();
		this.token = token;
		this.id = id;
		this.loginTime = loginTime;
		this.ip = ip;
	}

	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

	@Override
	public String toString() {
		return "Token [token=" + token + ", id=" + id + ", loginTime=" + loginTime + ", ip=" + ip + "]";
	}
}