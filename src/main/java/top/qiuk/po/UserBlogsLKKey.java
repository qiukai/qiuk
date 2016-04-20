package top.qiuk.po;

import java.io.Serializable;

public class UserBlogsLKKey implements Serializable{
	private static final long serialVersionUID = 1L;

	private String userId;

    private String blogsId;

    public UserBlogsLKKey() {
		super();
	}

	public UserBlogsLKKey(String userId, String blogsId) {
		super();
		this.userId = userId;
		this.blogsId = blogsId;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBlogsId() {
        return blogsId;
    }

    public void setBlogsId(String blogsId) {
        this.blogsId = blogsId;
    }

	@Override
	public String toString() {
		return "UserBlogsLKKey [userId=" + userId + ", blogsId=" + blogsId + "]";
	}
}