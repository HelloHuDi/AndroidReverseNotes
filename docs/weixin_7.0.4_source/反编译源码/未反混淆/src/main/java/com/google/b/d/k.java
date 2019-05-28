package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class k extends r {
    public final b a(String str, a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57227);
        if (aVar != a.EAN_8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57227);
            throw illegalArgumentException;
        }
        b a = super.a(str, aVar, i, i2, map);
        AppMethodBeat.o(57227);
        return a;
    }

    public final boolean[] bj(String str) {
        AppMethodBeat.i(57228);
        if (str.length() != 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
            AppMethodBeat.o(57228);
            throw illegalArgumentException;
        }
        int i;
        boolean[] zArr = new boolean[67];
        int a = o.a(zArr, 0, q.bAC, true) + 0;
        for (i = 0; i <= 3; i++) {
            a += o.a(zArr, a, q.bAE[Integer.parseInt(str.substring(i, i + 1))], false);
        }
        int a2 = a + o.a(zArr, a, q.bAD, false);
        for (i = 4; i <= 7; i++) {
            a2 += o.a(zArr, a2, q.bAE[Integer.parseInt(str.substring(i, i + 1))], true);
        }
        o.a(zArr, a2, q.bAC, true);
        AppMethodBeat.o(57228);
        return zArr;
    }
}
