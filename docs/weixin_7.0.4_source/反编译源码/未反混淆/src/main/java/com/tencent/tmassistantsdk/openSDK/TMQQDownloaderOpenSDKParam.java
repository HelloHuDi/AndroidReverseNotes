package com.tencent.tmassistantsdk.openSDK;

import com.facebook.appevents.AppEventsConstants;

public class TMQQDownloaderOpenSDKParam {
    public String SNGAppId = "";
    public String actionFlag = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public String channelId = "";
    public String sdkId = "";
    public String taskApkId = "";
    public String taskAppId = "";
    public String taskPackageName = "";
    public int taskVersion = 0;
    public String uin = "";
    public String uinType = "";
    public String via = "";

    public TMQQDownloaderOpenSDKParam(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.SNGAppId = str;
        this.taskAppId = str2;
        this.taskApkId = str3;
        this.taskVersion = i;
        this.via = str4;
        this.taskPackageName = str5;
        this.uin = str6;
        this.uinType = str7;
        this.channelId = str8;
        this.actionFlag = str9;
    }
}
