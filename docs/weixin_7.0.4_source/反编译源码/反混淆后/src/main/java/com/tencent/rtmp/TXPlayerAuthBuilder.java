package com.tencent.rtmp;

public class TXPlayerAuthBuilder {
    int appId;
    int exper = -1;
    String fileId;
    protected boolean isHttps;
    String sign;
    String timeout;
    /* renamed from: us */
    String f17270us;

    public int getAppId() {
        return this.appId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getTimeout() {
        return this.timeout;
    }

    public int getExper() {
        return this.exper;
    }

    public String getSign() {
        return this.sign;
    }

    public String getUs() {
        return this.f17270us;
    }

    public boolean isHttps() {
        return this.isHttps;
    }

    public void setAppId(int i) {
        this.appId = i;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setTimeout(String str) {
        this.timeout = str;
    }

    public void setUs(String str) {
        this.f17270us = str;
    }

    public void setExper(int i) {
        this.exper = i;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setHttps(boolean z) {
        this.isHttps = z;
    }
}
