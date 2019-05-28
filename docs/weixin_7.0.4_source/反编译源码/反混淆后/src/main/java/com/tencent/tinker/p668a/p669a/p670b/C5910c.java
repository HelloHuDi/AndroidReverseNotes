package com.tencent.tinker.p668a.p669a.p670b;

import com.tencent.mars.cdn.CdnLogic;

/* renamed from: com.tencent.tinker.a.a.b.c */
public final class C5910c {
    /* renamed from: a */
    private static int m9189a(byte b, byte b2) {
        if (b == b2) {
            return 0;
        }
        return (b & 255) < (b2 & 255) ? -1 : 1;
    }

    /* renamed from: b */
    public static int m9192b(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return (s & CdnLogic.kBizGeneric) < (CdnLogic.kBizGeneric & s2) ? -1 : 1;
    }

    /* renamed from: hX */
    public static int m9194hX(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return (((long) i) & 4294967295L) < (((long) i2) & 4294967295L) ? -1 : 1;
    }

    /* renamed from: o */
    public static int m9196o(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            length2 = C5910c.m9189a(bArr[i], bArr2[i]);
            if (length2 != 0) {
                return length2;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m9191a(short[] sArr, short[] sArr2) {
        int length = sArr.length;
        int length2 = sArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            length2 = C5910c.m9192b(sArr[i], sArr2[i]);
            if (length2 != 0) {
                return length2;
            }
        }
        return 0;
    }

    /* renamed from: hY */
    public static int m9195hY(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    /* renamed from: b */
    public static int m9193b(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            length2 = C5910c.m9195hY(iArr[i], iArr2[i]);
            if (length2 != 0) {
                return length2;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static <T extends Comparable<T>> int m9190a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            length2 = tArr[i].compareTo(tArr2[i]);
            if (length2 != 0) {
                return length2;
            }
        }
        return 0;
    }
}
