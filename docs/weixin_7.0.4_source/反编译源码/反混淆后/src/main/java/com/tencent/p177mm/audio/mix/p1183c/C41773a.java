package com.tencent.p177mm.audio.mix.p1183c;

/* renamed from: com.tencent.mm.audio.mix.c.a */
public final class C41773a {
    public static byte[] getBytes(short s, boolean z) {
        byte[] bArr = new byte[2];
        if (z) {
            bArr[1] = (byte) (s & 255);
            bArr[0] = (byte) (((short) (s >> 8)) & 255);
        } else {
            bArr[0] = (byte) (s & 255);
            bArr[1] = (byte) (((short) (s >> 8)) & 255);
        }
        return bArr;
    }

    /* renamed from: a */
    public static short m73736a(byte b, byte b2, boolean z) {
        if (z) {
            return (short) (((short) (((short) ((b & 255) | 0)) << 8)) | (b2 & 255));
        }
        return (short) (((short) (((short) ((b2 & 255) | 0)) << 8)) | (b & 255));
    }

    /* renamed from: a */
    public static byte[] m73737a(byte[] bArr, double d) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((int) (((double) bArr[i]) * d));
        }
        return bArr;
    }
}
