package top.qiuk.po;

import java.io.Serializable;

public class TagBlogsLKKey implements Serializable{
	private static final long serialVersionUID = 1L;

	private String tagId;

    private String blogsId;

    public TagBlogsLKKey() {
		super();
	}

	public TagBlogsLKKey(String tagId, String blogsId) {
		super();
		this.tagId = tagId;
		this.blogsId = blogsId;
	}

	public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getBlogsId() {
        return blogsId;
    }

    public void setBlogsId(String blogsId) {
        this.blogsId = blogsId;
    }

	@Override
	public String toString() {
		return "TagBlogsLKKey [tagId=" + tagId + ", blogsId=" + blogsId + "]";
	}
}