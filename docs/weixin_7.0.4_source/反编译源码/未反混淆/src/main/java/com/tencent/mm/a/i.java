package com.tencent.mm.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;

public final class i {
    public static int bL(int i, int i2) {
        int i3 = 0;
        if (i2 < 0 || i2 >= BaseClientBuilder.API_PRIORITY_OTHER) {
            return 0;
        }
        byte[] bArr = new byte[4];
        while (i3 < 4) {
            bArr[i3] = (byte) ((i >> (i3 * 8)) & 255);
            i3++;
        }
        return (int) ((((long) s(bArr, 4)) & 4294967295L) % ((long) i2));
    }

    public static int s(byte[] bArr, int i) {
        int i2;
        int i3 = i ^ 0;
        int i4 = i >> 2;
        for (i2 = 0; i2 < i4; i2++) {
            int i5 = (i2 << 2) + 0;
            i5 = ((bArr[i5 + 0] & 255) | (((((bArr[i5 + 3] << 8) | (bArr[i5 + 2] & 255)) << 8) | (bArr[i5 + 1] & 255)) << 8)) * 1540483477;
            i3 = (i3 * 1540483477) ^ ((i5 ^ (i5 >>> 24)) * 1540483477);
        }
        i2 = i - (i4 << 2);
        if (i2 != 0) {
            if (i2 >= 3) {
                i3 ^= bArr[(i + 0) - 3] << 16;
            }
            if (i2 >= 2) {
                i3 ^= bArr[(i + 0) - 2] << 8;
            }
            if (i2 > 0) {
                i3 ^= bArr[(i + 0) - 1];
            }
            i3 *= 1540483477;
        }
        i3 = (i3 ^ (i3 >>> 13)) * 1540483477;
        return i3 ^ (i3 >>> 15);
    }
}
