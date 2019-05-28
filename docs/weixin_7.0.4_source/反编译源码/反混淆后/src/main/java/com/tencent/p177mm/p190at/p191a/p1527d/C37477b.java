package com.tencent.p177mm.p190at.p191a.p1527d;

import android.graphics.Bitmap;

/* renamed from: com.tencent.mm.at.a.d.b */
public final class C37477b {
    public Bitmap bitmap;
    public String bqF;
    public byte[] data;
    public int from;
    public int status;

    public C37477b() {
        this.status = -1;
    }

    public C37477b(Bitmap bitmap) {
        this.status = 0;
        this.from = 0;
        this.bitmap = bitmap;
    }

    public C37477b(byte[] bArr, String str) {
        this.data = bArr;
        this.bqF = str;
    }

    public C37477b(byte[] bArr, String str, byte b) {
        this.data = bArr;
        this.from = 2;
        this.bqF = str;
    }
}
