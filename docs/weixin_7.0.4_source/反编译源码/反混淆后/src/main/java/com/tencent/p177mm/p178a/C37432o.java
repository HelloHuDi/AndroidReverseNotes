package com.tencent.p177mm.p178a;

/* renamed from: com.tencent.mm.a.o */
public final class C37432o {
    /* renamed from: t */
    public static int m63092t(byte[] bArr, int i) {
        return ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | ((bArr[i + 3] & 255) << 0);
    }

    /* renamed from: fZ */
    public static byte[] m63091fZ(int i) {
        int i2 = 0;
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3] = (byte) ((i >> (i3 * 8)) & 255);
        }
        byte[] bArr2 = new byte[4];
        while (i2 < 4) {
            bArr2[i2] = bArr[3 - i2];
            i2++;
        }
        return bArr2;
    }

    /* renamed from: A */
    public static int m63090A(byte[] bArr) {
        return ((((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16)) | ((bArr[1] & 255) << 8)) | ((bArr[0] & 255) << 0);
    }
}
