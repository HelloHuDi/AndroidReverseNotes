package com.google.b.a;

import com.google.b.b.b;
import com.google.b.c;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.Map;

public final class a implements g {
    private static final Charset byj = Charset.forName("ISO-8859-1");

    static {
        AppMethodBeat.i(57191);
        AppMethodBeat.o(57191);
    }

    public final b a(String str, com.google.b.a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57189);
        Charset charset = byj;
        int i3 = 33;
        int i4 = 0;
        if (map != null) {
            if (map.containsKey(c.CHARACTER_SET)) {
                charset = Charset.forName(map.get(c.CHARACTER_SET).toString());
            }
            if (map.containsKey(c.ERROR_CORRECTION)) {
                i3 = Integer.parseInt(map.get(c.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(c.AZTEC_LAYERS)) {
                i4 = Integer.parseInt(map.get(c.AZTEC_LAYERS).toString());
            }
        }
        if (aVar != com.google.b.a.AZTEC) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57189);
            throw illegalArgumentException;
        }
        b a = a(com.google.b.a.a.c.n(str.getBytes(charset), i3, i4), i, i2);
        AppMethodBeat.o(57189);
        return a;
    }

    private static b a(com.google.b.a.a.a aVar, int i, int i2) {
        AppMethodBeat.i(57190);
        b bVar = aVar.byn;
        if (bVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(57190);
            throw illegalStateException;
        }
        int i3 = bVar.width;
        int i4 = bVar.height;
        int max = Math.max(i, i3);
        int max2 = Math.max(i2, i4);
        int min = Math.min(max / i3, max2 / i4);
        int i5 = (max - (i3 * min)) / 2;
        int i6 = (max2 - (i4 * min)) / 2;
        b bVar2 = new b(max, max2);
        max2 = i6;
        for (int i7 = 0; i7 < i4; i7++) {
            i6 = i5;
            max = 0;
            while (max < i3) {
                if (bVar.bB(max, i7)) {
                    bVar2.p(i6, max2, min, min);
                }
                max++;
                i6 += min;
            }
            max2 += min;
        }
        AppMethodBeat.o(57190);
        return bVar2;
    }
}
