package top.qiuk.po;

import java.io.Serializable;
import java.util.Date;

public class BlogsLog implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;

    private String title;

    private Date createTime;

    private String primaryId;

    private String logId;

    private Integer logType;

    private String content;

    public BlogsLog() {
		super();
	}

	public BlogsLog(String id, String title, Date createTime, String primaryId, String logId, Integer logType,
			String content) {
		super();
		this.id = id;
		this.title = title;
		this.createTime = createTime;
		this.primaryId = primaryId;
		this.logId = logId;
		this.logType = logType;
		this.content = content;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	@Override
	public String toString() {
		return "BlogsLog [id=" + id + ", title=" + title + ", createTime=" + createTime + ", primaryId=" + primaryId
				+ ", logId=" + logId + ", logType=" + logType + ", content=" + content + "]";
	}
}