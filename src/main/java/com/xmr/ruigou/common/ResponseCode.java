package com.xmr.ruigou.common;

/**
 * Created by xmr on 2019/12/3.
 */
public enum ResponseCode {
    //枚举类型
    ERROR(0, "ERROR"),
    SUCCESS(200, "SUCCESS"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;


    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
