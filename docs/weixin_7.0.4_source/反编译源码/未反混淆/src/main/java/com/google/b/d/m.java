package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class m extends o {
    private static final int[] bAA = new int[]{3, 1, 1};
    private static final int[] bAx = new int[]{1, 1, 1, 1};

    public final b a(String str, a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57317);
        if (aVar != a.ITF) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57317);
            throw illegalArgumentException;
        }
        b a = super.a(str, aVar, i, i2, map);
        AppMethodBeat.o(57317);
        return a;
    }

    public final boolean[] bj(String str) {
        AppMethodBeat.i(57318);
        int length = str.length();
        IllegalArgumentException illegalArgumentException;
        if (length % 2 != 0) {
            illegalArgumentException = new IllegalArgumentException("The length of the input should be even");
            AppMethodBeat.o(57318);
            throw illegalArgumentException;
        } else if (length > 80) {
            illegalArgumentException = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            AppMethodBeat.o(57318);
            throw illegalArgumentException;
        } else {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a = o.a(zArr, 0, bAx, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[18];
                for (int i2 = 0; i2 < 5; i2++) {
                    iArr[i2 * 2] = l.bAz[digit][i2];
                    iArr[(i2 * 2) + 1] = l.bAz[digit2][i2];
                }
                a += o.a(zArr, a, iArr, true);
            }
            o.a(zArr, a, bAA, true);
            AppMethodBeat.o(57318);
            return zArr;
        }
    }
}
