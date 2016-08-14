package top.qiuk.po;

import java.io.Serializable;
import java.util.Date;

public class UserLog implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String email;

	private String nickName;

	private String password;

	private Integer status;

	private Date createTime;

	private String primaryId;

	private String logId;

	private Integer logType;

	public UserLog() {
		super();
	}

	public UserLog(String id, String email, String nickName, String password, Integer status, Date createTime,
			String primaryId, String logId, Integer logType) {
		super();
		this.id = id;
		this.email = email;
		this.nickName = nickName;
		this.password = password;
		this.status = status;
		this.createTime = createTime;
		this.primaryId = primaryId;
		this.logId = logId;
		this.logType = logType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	@Override
	public String toString() {
		return "UserLog [id=" + id + ", email=" + email + ", nickName=" + nickName + ", password=" + password
				+ ", status=" + status + ", createTime=" + createTime + ", primaryId=" + primaryId + ", logId=" + logId
				+ ", logType=" + logType + "]";
	}
}