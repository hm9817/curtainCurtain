package com.entity;

public class Common {
	
	/** 类型 - 轮播图 */
	public static final byte TYPE_BANNER = 1;
	/** 类型 - 二维码 */
	public static final byte TYPE_QRCODE = 2;
	/** 类型 - 条幅文字 */
	public static final byte TYPE_TEXT = 3;
	
    private Integer id;

    private Byte type;

    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}