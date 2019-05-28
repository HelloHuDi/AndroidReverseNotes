package com.tencent.mm.audio.mix.c;

public final class a {
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

    public static short a(byte b, byte b2, boolean z) {
        if (z) {
            return (short) (((short) (((short) ((b & 255) | 0)) << 8)) | (b2 & 255));
        }
        return (short) (((short) (((short) ((b2 & 255) | 0)) << 8)) | (b & 255));
    }

    public static byte[] a(byte[] bArr, double d) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((int) (((double) bArr[i]) * d));
        }
        return bArr;
    }
}
