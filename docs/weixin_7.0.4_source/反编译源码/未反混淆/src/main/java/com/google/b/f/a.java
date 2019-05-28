package com.google.b.f;

import com.google.b.b.b;
import com.google.b.c;
import com.google.b.f.b.f;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class a implements g {
    public final b a(String str, com.google.b.a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57258);
        IllegalArgumentException illegalArgumentException;
        if (str.isEmpty()) {
            illegalArgumentException = new IllegalArgumentException("Found empty contents");
            AppMethodBeat.o(57258);
            throw illegalArgumentException;
        } else if (aVar != com.google.b.a.QR_CODE) {
            illegalArgumentException = new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57258);
            throw illegalArgumentException;
        } else if (i < 0 || i2 < 0) {
            illegalArgumentException = new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
            AppMethodBeat.o(57258);
            throw illegalArgumentException;
        } else {
            com.google.b.f.a.a aVar2 = com.google.b.f.a.a.L;
            int i3 = 4;
            if (map != null) {
                if (map.containsKey(c.ERROR_CORRECTION)) {
                    aVar2 = com.google.b.f.a.a.valueOf(map.get(c.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(c.MARGIN)) {
                    i3 = Integer.parseInt(map.get(c.MARGIN).toString());
                }
            }
            b a = a(com.google.b.f.b.c.a(str, aVar2, (Map) map), i, i2, i3);
            AppMethodBeat.o(57258);
            return a;
        }
    }

    private static b a(f fVar, int i, int i2, int i3) {
        AppMethodBeat.i(57259);
        com.google.b.f.b.b bVar = fVar.bBU;
        if (bVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(57259);
            throw illegalStateException;
        }
        int i4 = bVar.width;
        int i5 = bVar.height;
        int i6 = (i3 << 1) + i4;
        int i7 = (i3 << 1) + i5;
        int max = Math.max(i, i6);
        int max2 = Math.max(i2, i7);
        int min = Math.min(max / i6, max2 / i7);
        i7 = (max - (i4 * min)) / 2;
        i6 = (max2 - (i5 * min)) / 2;
        b bVar2 = new b(max, max2);
        max2 = i6;
        for (int i8 = 0; i8 < i5; i8++) {
            max = 0;
            i6 = i7;
            while (max < i4) {
                if (bVar.bH(max, i8) == (byte) 1) {
                    bVar2.p(i6, max2, min, min);
                }
                max++;
                i6 += min;
            }
            max2 += min;
        }
        AppMethodBeat.o(57259);
        return bVar2;
    }
}
