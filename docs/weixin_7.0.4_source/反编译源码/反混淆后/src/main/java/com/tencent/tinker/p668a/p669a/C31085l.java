package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.p670b.C24423b;
import com.tencent.tinker.p668a.p669a.p670b.C46809a;

/* renamed from: com.tencent.tinker.a.a.l */
public final class C31085l {
    /* renamed from: a */
    public static void m50143a(C24423b c24423b, int i, long j) {
        int numberOfLeadingZeros = ((65 - Long.numberOfLeadingZeros((j >> 63) ^ j)) + 7) >> 3;
        c24423b.writeByte(((numberOfLeadingZeros - 1) << 5) | i);
        while (numberOfLeadingZeros > 0) {
            c24423b.writeByte((byte) ((int) j));
            j >>= 8;
            numberOfLeadingZeros--;
        }
    }

    /* renamed from: b */
    public static void m50144b(C24423b c24423b, int i, long j) {
        int numberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros == 0) {
            numberOfLeadingZeros = 1;
        }
        numberOfLeadingZeros = (numberOfLeadingZeros + 7) >> 3;
        c24423b.writeByte(((numberOfLeadingZeros - 1) << 5) | i);
        while (numberOfLeadingZeros > 0) {
            c24423b.writeByte((byte) ((int) j));
            j >>= 8;
            numberOfLeadingZeros--;
        }
    }

    /* renamed from: c */
    public static void m50145c(C24423b c24423b, int i, long j) {
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j);
        if (numberOfTrailingZeros == 0) {
            numberOfTrailingZeros = 1;
        }
        numberOfTrailingZeros = (numberOfTrailingZeros + 7) >> 3;
        long j2 = j >> (64 - (numberOfTrailingZeros * 8));
        c24423b.writeByte(((numberOfTrailingZeros - 1) << 5) | i);
        while (numberOfTrailingZeros > 0) {
            c24423b.writeByte((byte) ((int) j2));
            j2 >>= 8;
            numberOfTrailingZeros--;
        }
    }

    /* renamed from: a */
    public static int m50141a(C46809a c46809a, int i) {
        int i2 = 0;
        for (int i3 = i; i3 >= 0; i3--) {
            i2 = (i2 >>> 8) | ((c46809a.readByte() & 255) << 24);
        }
        return i2 >> ((3 - i) * 8);
    }

    /* renamed from: a */
    public static int m50142a(C46809a c46809a, int i, boolean z) {
        int i2 = 0;
        if (z) {
            while (i >= 0) {
                i2 = (i2 >>> 8) | ((c46809a.readByte() & 255) << 24);
                i--;
            }
            return i2;
        }
        for (int i3 = i; i3 >= 0; i3--) {
            i2 = (i2 >>> 8) | ((c46809a.readByte() & 255) << 24);
        }
        return i2 >>> ((3 - i) * 8);
    }
}
