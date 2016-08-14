package top.qiuk.po;

import java.io.Serializable;
import java.util.Date;

public class Blogs implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String title;

	private Date createTime;

	private String content;

	public Blogs() {
		super();
	}

	public Blogs(String id, String title, Date createTime, String content) {
		super();
		this.id = id;
		this.title = title;
		this.createTime = createTime;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Blogs [id=" + id + ", title=" + title + ", createTime=" + createTime + ", content=" + content + "]";
	}
}