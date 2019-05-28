package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class h extends o {
    public final b a(String str, a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57173);
        if (aVar != a.CODE_93) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57173);
            throw illegalArgumentException;
        }
        b a = super.a(str, aVar, i, i2, map);
        AppMethodBeat.o(57173);
        return a;
    }

    public final boolean[] bj(String str) {
        int i = 0;
        AppMethodBeat.i(57174);
        int length = str.length();
        if (length > 80) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            AppMethodBeat.o(57174);
            throw illegalArgumentException;
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[((((str.length() + 2) + 2) * 9) + 1)];
        b(g.bAi[47], iArr);
        int a = a(zArr, 0, iArr);
        while (i < length) {
            b(g.bAi["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i))], iArr);
            a += a(zArr, a, iArr);
            i++;
        }
        i = l(str, 20);
        b(g.bAi[i], iArr);
        a += a(zArr, a, iArr);
        b(g.bAi[l(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(i), 15)], iArr);
        i = a(zArr, a, iArr) + a;
        b(g.bAi[47], iArr);
        zArr[i + a(zArr, i, iArr)] = true;
        AppMethodBeat.o(57174);
        return zArr;
    }

    private static void b(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            iArr[i2] = i3;
        }
    }

    private static int a(boolean[] zArr, int i, int[] iArr) {
        int i2 = 0;
        while (i2 < 9) {
            boolean z;
            int i3 = i + 1;
            if (iArr[i2] != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
            i2++;
            i = i3;
        }
        return 9;
    }

    private static int l(String str, int i) {
        int i2;
        AppMethodBeat.i(57175);
        int i3 = 0;
        int length = str.length() - 1;
        int i4 = 1;
        while (length >= 0) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i4;
            i2 = i4 + 1;
            if (i2 > i) {
                i2 = 1;
            }
            length--;
            i4 = i2;
        }
        i2 = i3 % 47;
        AppMethodBeat.o(57175);
        return i2;
    }
}
