package top.qiuk.po;

import java.io.Serializable;
import java.util.Date;

public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String tagName;

	private Date createTime;

	public Tag() {
		super();
	}

	public Tag(String id, String tagName, Date createTime) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagName=" + tagName + ", createTime=" + createTime + "]";
	}
}