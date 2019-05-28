package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class t extends r {
    public final b a(String str, a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57155);
        if (aVar != a.UPC_E) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57155);
            throw illegalArgumentException;
        }
        b a = super.a(str, aVar, i, i2, map);
        AppMethodBeat.o(57155);
        return a;
    }

    public final boolean[] bj(String str) {
        AppMethodBeat.i(57156);
        if (str.length() != 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
            AppMethodBeat.o(57156);
            throw illegalArgumentException;
        }
        int i = s.bAG[Integer.parseInt(str.substring(7, 8))];
        boolean[] zArr = new boolean[51];
        int a = o.a(zArr, 0, q.bAC, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int parseInt = Integer.parseInt(str.substring(i2, i2 + 1));
            if (((i >> (6 - i2)) & 1) == 1) {
                parseInt += 10;
            }
            a += o.a(zArr, a, q.bAF[parseInt], false);
        }
        o.a(zArr, a, q.bAA, false);
        AppMethodBeat.o(57156);
        return zArr;
    }
}
