package com.tencent.mm.a;

final class j {
    public byte[] cca;
    public int ccb;

    public j() {
        this.ccb = 0;
        this.cca = new byte[256];
    }

    public j(byte b) {
        this.ccb = 0;
        this.cca = new byte[]{b};
    }

    public j(byte[] bArr) {
        this.ccb = 0;
        this.cca = bArr;
    }
}
