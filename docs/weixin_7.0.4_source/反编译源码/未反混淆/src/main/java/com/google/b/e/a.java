package com.google.b.e;

import com.google.b.b.b;
import com.google.b.c;
import com.google.b.e.a.d;
import com.google.b.e.a.e;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

public final class a implements g {
    public final b a(String str, com.google.b.a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57235);
        if (aVar != com.google.b.a.PDF_417) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57235);
            throw illegalArgumentException;
        }
        int i3;
        int i4;
        int parseInt;
        e eVar = new e();
        int i5 = 2;
        if (map != null) {
            if (map.containsKey(c.PDF417_COMPACT)) {
                eVar.byk = Boolean.valueOf(map.get(c.PDF417_COMPACT).toString()).booleanValue();
            }
            if (map.containsKey(c.PDF417_COMPACTION)) {
                eVar.bAX = com.google.b.e.a.c.valueOf(map.get(c.PDF417_COMPACTION).toString());
            }
            if (map.containsKey(c.PDF417_DIMENSIONS)) {
                d dVar = (d) map.get(c.PDF417_DIMENSIONS);
                i3 = dVar.bAT;
                int i6 = dVar.bAS;
                int i7 = dVar.maxRows;
                i4 = dVar.bAU;
                eVar.bAT = i3;
                eVar.bAS = i6;
                eVar.maxRows = i7;
                eVar.bAU = i4;
            }
            if (map.containsKey(c.MARGIN)) {
                i4 = Integer.parseInt(map.get(c.MARGIN).toString());
            } else {
                i4 = 30;
            }
            if (map.containsKey(c.ERROR_CORRECTION)) {
                parseInt = Integer.parseInt(map.get(c.ERROR_CORRECTION).toString());
            } else {
                parseInt = 2;
            }
            if (map.containsKey(c.CHARACTER_SET)) {
                eVar.bAY = Charset.forName(map.get(c.CHARACTER_SET).toString());
            }
            i5 = parseInt;
        } else {
            i4 = 30;
        }
        eVar.m(str, i5);
        byte[][] bG = eVar.bAW.bG(1, 4);
        parseInt = i2 > i ? 1 : 0;
        if (bG[0].length < bG.length) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if ((parseInt ^ i3) != 0) {
            bG = a(bG);
            parseInt = 1;
        } else {
            parseInt = 0;
        }
        i3 = i / bG[0].length;
        int length = i2 / bG.length;
        if (i3 < length) {
            length = i3;
        }
        b a;
        if (length > 1) {
            byte[][] a2;
            bG = eVar.bAW.bG(length, length << 2);
            if (parseInt != 0) {
                a2 = a(bG);
            } else {
                a2 = bG;
            }
            a = a(a2, i4);
            AppMethodBeat.o(57235);
            return a;
        }
        a = a(bG, i4);
        AppMethodBeat.o(57235);
        return a;
    }

    private static b a(byte[][] bArr, int i) {
        AppMethodBeat.i(57236);
        b bVar = new b(bArr[0].length + (i * 2), bArr.length + (i * 2));
        bVar.clear();
        int i2 = (bVar.height - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr[i3][i4] == (byte) 1) {
                    bVar.set(i4 + i, i2);
                }
            }
            i3++;
            i2--;
        }
        AppMethodBeat.o(57236);
        return bVar;
    }

    private static byte[][] a(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{bArr[0].length, bArr.length});
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }
}
