package com.tencent.tmassistantsdk.openSDK;

public class TMQQDownloaderStateChangeParam {
    public int errorCode;
    public String errorMsg;
    public String hostPackageName;
    public String hostVersion;
    public TMQQDownloaderOpenSDKParam param;
    public int state;
    public String taskId;

    public TMQQDownloaderStateChangeParam(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str, String str2, String str3, int i, int i2, String str4) {
        this.param = tMQQDownloaderOpenSDKParam;
        this.hostPackageName = str;
        this.hostVersion = str2;
        this.taskId = str3;
        this.state = i;
        this.errorCode = i2;
        this.errorMsg = str4;
    }
}
