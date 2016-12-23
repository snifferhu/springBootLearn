package com.webbase;

/**
 * @auth snifferhu
 * @date 2016/12/22 22:22
 */
public class ReturnInfo<T> {
    public static final Integer OK = 1;
    private Integer code;
    private String message;
    private String url;
    private T data;

    public ReturnInfo() {
    }

    public ReturnInfo(Integer code, String message, String url, T data) {
        this.code = code;
        this.message = message;
        this.url = url;
        this.data = data;
    }

    public static Integer getOK() {
        return OK;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReturnInfo{");
        sb.append("code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}