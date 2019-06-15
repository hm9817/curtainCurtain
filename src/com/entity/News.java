package com.entity;

import java.util.Date;

public class News {
	
	/** 公司新闻 */
	public static final byte TYPE_COMPANY = 1;
	/** 行业动态 */
	public static final byte TYPE_INDUSTRY = 2;
	
	
    private Integer id;

    private byte type;
    
    private String photo;
    
    private String title;

    private Date time;

    private String intro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
    
}