package com.example.model.qo;

/**
 * Created by Sniff on 2018/5/8.
 */
public class UsersMerchantsQo {
    private String tokenExpireTime;
    private String token;
    private String merchantId;
    private String bindName;
    private String userName;
    public void setTokenExpireTime(String tokenExpireTime) {
        this.tokenExpireTime = tokenExpireTime;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public void setBindName(String bindName) {
        this.bindName = bindName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTokenExpireTime() {
        return tokenExpireTime;
    }

    public String getToken() {
        return token;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getBindName() {
        return bindName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UsersMerchantsQo{");
        sb.append("tokenExpireTime=").append(tokenExpireTime);
        sb.append(", token='").append(token).append('\'');
        sb.append(", merchantId='").append(merchantId).append('\'');
        sb.append(", bindName='").append(bindName).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
