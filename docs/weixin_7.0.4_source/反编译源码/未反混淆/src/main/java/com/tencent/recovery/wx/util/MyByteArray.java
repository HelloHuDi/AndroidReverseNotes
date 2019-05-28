package com.tencent.recovery.wx.util;

class MyByteArray {
    public byte[] cca;
    public int ccb;

    public MyByteArray() {
        this.ccb = 0;
        this.cca = new byte[256];
    }

    public MyByteArray(byte b) {
        this.ccb = 0;
        this.cca = new byte[]{b};
    }

    public MyByteArray(byte[] bArr) {
        this.ccb = 0;
        this.cca = bArr;
    }
}
