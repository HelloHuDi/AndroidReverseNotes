package com.tencent.wxmm;

public interface IVoipCallBack {
    void callBackFromVoip1(int i, int i2, byte[] bArr);

    byte[] callBackFromVoip2(int i, int i2, byte[] bArr);
}
