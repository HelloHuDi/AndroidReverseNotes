package com.tencent.tinker.p668a.p671b.p672b;

/* renamed from: com.tencent.tinker.a.b.b.a */
public final class C5917a {
    /* renamed from: nF */
    public static String m9204nF(long j) {
        char[] cArr = new char[16];
        for (int i = 0; i < 16; i++) {
            cArr[15 - i] = Character.forDigit(((int) j) & 15, 16);
            j >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: RE */
    public static String m9200RE(int i) {
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[7 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: RF */
    public static String m9201RF(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[3 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: RG */
    public static String m9202RG(int i) {
        if (i == ((char) i)) {
            return C5917a.m9201RF(i);
        }
        return C5917a.m9200RE(i);
    }

    /* renamed from: RH */
    public static String m9203RH(int i) {
        int i2 = 0;
        char[] cArr = new char[9];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        while (i2 < 8) {
            cArr[8 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
            i2++;
        }
        return new String(cArr);
    }
}
