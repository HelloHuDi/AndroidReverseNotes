package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;
import com.tencent.tinker.a.a.b.b;

public final class l {
    public static void a(b bVar, int i, long j) {
        int numberOfLeadingZeros = ((65 - Long.numberOfLeadingZeros((j >> 63) ^ j)) + 7) >> 3;
        bVar.writeByte(((numberOfLeadingZeros - 1) << 5) | i);
        while (numberOfLeadingZeros > 0) {
            bVar.writeByte((byte) ((int) j));
            j >>= 8;
            numberOfLeadingZeros--;
        }
    }

    public static void b(b bVar, int i, long j) {
        int numberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros == 0) {
            numberOfLeadingZeros = 1;
        }
        numberOfLeadingZeros = (numberOfLeadingZeros + 7) >> 3;
        bVar.writeByte(((numberOfLeadingZeros - 1) << 5) | i);
        while (numberOfLeadingZeros > 0) {
            bVar.writeByte((byte) ((int) j));
            j >>= 8;
            numberOfLeadingZeros--;
        }
    }

    public static void c(b bVar, int i, long j) {
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j);
        if (numberOfTrailingZeros == 0) {
            numberOfTrailingZeros = 1;
        }
        numberOfTrailingZeros = (numberOfTrailingZeros + 7) >> 3;
        long j2 = j >> (64 - (numberOfTrailingZeros * 8));
        bVar.writeByte(((numberOfTrailingZeros - 1) << 5) | i);
        while (numberOfTrailingZeros > 0) {
            bVar.writeByte((byte) ((int) j2));
            j2 >>= 8;
            numberOfTrailingZeros--;
        }
    }

    public static int a(a aVar, int i) {
        int i2 = 0;
        for (int i3 = i; i3 >= 0; i3--) {
            i2 = (i2 >>> 8) | ((aVar.readByte() & 255) << 24);
        }
        return i2 >> ((3 - i) * 8);
    }

    public static int a(a aVar, int i, boolean z) {
        int i2 = 0;
        if (z) {
            while (i >= 0) {
                i2 = (i2 >>> 8) | ((aVar.readByte() & 255) << 24);
                i--;
            }
            return i2;
        }
        for (int i3 = i; i3 >= 0; i3--) {
            i2 = (i2 >>> 8) | ((aVar.readByte() & 255) << 24);
        }
        return i2 >>> ((3 - i) * 8);
    }
}
