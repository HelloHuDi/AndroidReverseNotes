package com.tencent.wxmm;

public interface IConfCallBack {
    byte[] callBackFromConf(int i, int i2, byte[] bArr);

    void callbackWriteLog(int i, String str, String str2, int i2, String str3, String str4, int i3);
}
