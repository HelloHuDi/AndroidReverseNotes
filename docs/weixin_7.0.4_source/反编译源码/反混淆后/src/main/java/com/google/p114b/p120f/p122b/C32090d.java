package com.google.p114b.p120f.p122b;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.b.f.b.d */
final class C32090d {
    /* renamed from: o */
    static boolean m52210o(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(57180);
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == (byte) 1) {
                AppMethodBeat.m2505o(57180);
                return false;
            }
        }
        AppMethodBeat.m2505o(57180);
        return true;
    }

    /* renamed from: a */
    static boolean m52209a(byte[][] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(57181);
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max][i] == (byte) 1) {
                AppMethodBeat.m2505o(57181);
                return false;
            }
        }
        AppMethodBeat.m2505o(57181);
        return true;
    }

    /* renamed from: a */
    static int m52208a(C8738b c8738b, boolean z) {
        int i;
        int i2;
        if (z) {
            i = c8738b.height;
        } else {
            i = c8738b.width;
        }
        if (z) {
            i2 = c8738b.width;
        } else {
            i2 = c8738b.height;
        }
        byte[][] bArr = c8738b.bBJ;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            byte b = (byte) -1;
            int i5 = 0;
            int i6 = 0;
            while (i5 < i2) {
                byte b2 = z ? bArr[i3][i5] : bArr[i5][i3];
                if (b2 == b) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i4 += (i6 - 5) + 3;
                    }
                    i6 = 1;
                    b = b2;
                }
                i5++;
            }
            if (i6 >= 5) {
                i4 += (i6 - 5) + 3;
            }
            i3++;
        }
        return i4;
    }
}
