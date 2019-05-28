package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.google.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j extends r {
    public final b a(String str, a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57326);
        if (aVar != a.EAN_13) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57326);
            throw illegalArgumentException;
        }
        b a = super.a(str, aVar, i, i2, map);
        AppMethodBeat.o(57326);
        return a;
    }

    public final boolean[] bj(String str) {
        AppMethodBeat.i(57327);
        IllegalArgumentException illegalArgumentException;
        if (str.length() != 13) {
            illegalArgumentException = new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
            AppMethodBeat.o(57327);
            throw illegalArgumentException;
        }
        try {
            if (q.r(str)) {
                int i;
                int parseInt;
                int i2 = i.bAv[Integer.parseInt(str.substring(0, 1))];
                boolean[] zArr = new boolean[95];
                int a = o.a(zArr, 0, q.bAC, true) + 0;
                for (i = 1; i <= 6; i++) {
                    parseInt = Integer.parseInt(str.substring(i, i + 1));
                    if (((i2 >> (6 - i)) & 1) == 1) {
                        parseInt += 10;
                    }
                    a += o.a(zArr, a, q.bAF[parseInt], false);
                }
                i = a + o.a(zArr, a, q.bAD, false);
                for (parseInt = 7; parseInt <= 12; parseInt++) {
                    i += o.a(zArr, i, q.bAE[Integer.parseInt(str.substring(parseInt, parseInt + 1))], true);
                }
                o.a(zArr, i, q.bAC, true);
                AppMethodBeat.o(57327);
                return zArr;
            }
            illegalArgumentException = new IllegalArgumentException("Contents do not pass checksum");
            AppMethodBeat.o(57327);
            throw illegalArgumentException;
        } catch (d e) {
            illegalArgumentException = new IllegalArgumentException("Illegal contents");
            AppMethodBeat.o(57327);
            throw illegalArgumentException;
        }
    }
}
