package com.tencent.mm.at.a.d;

import android.graphics.Bitmap;

public final class b {
    public Bitmap bitmap;
    public String bqF;
    public byte[] data;
    public int from;
    public int status;

    public b() {
        this.status = -1;
    }

    public b(Bitmap bitmap) {
        this.status = 0;
        this.from = 0;
        this.bitmap = bitmap;
    }

    public b(byte[] bArr, String str) {
        this.data = bArr;
        this.bqF = str;
    }

    public b(byte[] bArr, String str, byte b) {
        this.data = bArr;
        this.from = 2;
        this.bqF = str;
    }
}
