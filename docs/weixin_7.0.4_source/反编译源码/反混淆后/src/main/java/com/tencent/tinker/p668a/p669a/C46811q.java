package com.tencent.tinker.p668a.p669a;

import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;

/* renamed from: com.tencent.tinker.a.a.q */
public final class C46811q {
    /* renamed from: c */
    public static void m89019c(byte[] bArr, int i, String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3;
            char charAt = str.charAt(i2);
            int i4;
            if (charAt != 0 && charAt <= 127) {
                i3 = i + 1;
                bArr[i] = (byte) charAt;
            } else if (charAt <= 2047) {
                i4 = i + 1;
                bArr[i] = (byte) (((charAt >> 6) & 31) | C33250az.CTRL_INDEX);
                i3 = i4 + 1;
                bArr[i4] = (byte) ((charAt & 63) | 128);
            } else {
                i3 = i + 1;
                bArr[i] = (byte) (((charAt >> 12) & 15) | 224);
                i4 = i3 + 1;
                bArr[i3] = (byte) (((charAt >> 6) & 63) | 128);
                i3 = i4 + 1;
                bArr[i4] = (byte) ((charAt & 63) | 128);
            }
            i2++;
            i = i3;
        }
    }
}
