package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a {
    private static final char[] BZn = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final int[] BZo;

    static {
        AppMethodBeat.i(77306);
        int[] iArr = new int[256];
        BZo = iArr;
        Arrays.fill(iArr, -1);
        int length = BZn.length;
        for (int i = 0; i < length; i++) {
            BZo[BZn[i]] = i;
        }
        BZo[61] = 0;
        AppMethodBeat.o(77306);
    }

    public static final char[] cQ(byte[] bArr) {
        int i = 0;
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return new char[0];
        }
        int i2 = (length / 3) * 3;
        int i3 = (((length - 1) / 3) + 1) << 2;
        int i4 = i3 + (((i3 - 1) / 76) << 1);
        char[] cArr = new char[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i7 < i2) {
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            i8 = ((bArr[i8] & 255) << 8) | ((bArr[i7] & 255) << 16);
            i7 = i9 + 1;
            i8 |= bArr[i9] & 255;
            i9 = i6 + 1;
            cArr[i6] = BZn[(i8 >>> 18) & 63];
            i6 = i9 + 1;
            cArr[i9] = BZn[(i8 >>> 12) & 63];
            i9 = i6 + 1;
            cArr[i6] = BZn[(i8 >>> 6) & 63];
            i6 = i9 + 1;
            cArr[i9] = BZn[i8 & 63];
            i5++;
            if (i5 == 19 && i6 < i4 - 2) {
                i5 = i6 + 1;
                cArr[i6] = 13;
                i6 = i5 + 1;
                cArr[i5] = 10;
                i5 = 0;
            }
        }
        i5 = length - i2;
        if (i5 > 0) {
            i6 = (bArr[i2] & 255) << 10;
            if (i5 == 2) {
                i = (bArr[length - 1] & 255) << 2;
            }
            i |= i6;
            cArr[i4 - 4] = BZn[i >> 12];
            cArr[i4 - 3] = BZn[(i >>> 6) & 63];
            cArr[i4 - 2] = i5 == 2 ? BZn[i & 63] : '=';
            cArr[i4 - 1] = '=';
        }
        return cArr;
    }
}
