package com.google.b.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d {
    static boolean o(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(57180);
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == (byte) 1) {
                AppMethodBeat.o(57180);
                return false;
            }
        }
        AppMethodBeat.o(57180);
        return true;
    }

    static boolean a(byte[][] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(57181);
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max][i] == (byte) 1) {
                AppMethodBeat.o(57181);
                return false;
            }
        }
        AppMethodBeat.o(57181);
        return true;
    }

    static int a(b bVar, boolean z) {
        int i;
        int i2;
        if (z) {
            i = bVar.height;
        } else {
            i = bVar.width;
        }
        if (z) {
            i2 = bVar.width;
        } else {
            i2 = bVar.height;
        }
        byte[][] bArr = bVar.bBJ;
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
