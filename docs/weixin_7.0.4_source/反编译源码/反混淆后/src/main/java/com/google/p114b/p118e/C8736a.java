package com.google.p114b.p118e;

import com.google.p114b.C25577g;
import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p118e.p119a.C32087c;
import com.google.p114b.p118e.p119a.C32088d;
import com.google.p114b.p118e.p119a.C8734e;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* renamed from: com.google.b.e.a */
public final class C8736a implements C25577g {
    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57235);
        if (c37292a != C37292a.PDF_417) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57235);
            throw illegalArgumentException;
        }
        int i3;
        int i4;
        int parseInt;
        C8734e c8734e = new C8734e();
        int i5 = 2;
        if (map != null) {
            if (map.containsKey(C41638c.PDF417_COMPACT)) {
                c8734e.byk = Boolean.valueOf(map.get(C41638c.PDF417_COMPACT).toString()).booleanValue();
            }
            if (map.containsKey(C41638c.PDF417_COMPACTION)) {
                c8734e.bAX = C32087c.valueOf(map.get(C41638c.PDF417_COMPACTION).toString());
            }
            if (map.containsKey(C41638c.PDF417_DIMENSIONS)) {
                C32088d c32088d = (C32088d) map.get(C41638c.PDF417_DIMENSIONS);
                i3 = c32088d.bAT;
                int i6 = c32088d.bAS;
                int i7 = c32088d.maxRows;
                i4 = c32088d.bAU;
                c8734e.bAT = i3;
                c8734e.bAS = i6;
                c8734e.maxRows = i7;
                c8734e.bAU = i4;
            }
            if (map.containsKey(C41638c.MARGIN)) {
                i4 = Integer.parseInt(map.get(C41638c.MARGIN).toString());
            } else {
                i4 = 30;
            }
            if (map.containsKey(C41638c.ERROR_CORRECTION)) {
                parseInt = Integer.parseInt(map.get(C41638c.ERROR_CORRECTION).toString());
            } else {
                parseInt = 2;
            }
            if (map.containsKey(C41638c.CHARACTER_SET)) {
                c8734e.bAY = Charset.forName(map.get(C41638c.CHARACTER_SET).toString());
            }
            i5 = parseInt;
        } else {
            i4 = 30;
        }
        c8734e.mo19750m(str, i5);
        byte[][] bG = c8734e.bAW.mo52654bG(1, 4);
        parseInt = i2 > i ? 1 : 0;
        if (bG[0].length < bG.length) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if ((parseInt ^ i3) != 0) {
            bG = C8736a.m15555a(bG);
            parseInt = 1;
        } else {
            parseInt = 0;
        }
        i3 = i / bG[0].length;
        int length = i2 / bG.length;
        if (i3 < length) {
            length = i3;
        }
        C45061b a;
        if (length > 1) {
            byte[][] a2;
            bG = c8734e.bAW.mo52654bG(length, length << 2);
            if (parseInt != 0) {
                a2 = C8736a.m15555a(bG);
            } else {
                a2 = bG;
            }
            a = C8736a.m15554a(a2, i4);
            AppMethodBeat.m2505o(57235);
            return a;
        }
        a = C8736a.m15554a(bG, i4);
        AppMethodBeat.m2505o(57235);
        return a;
    }

    /* renamed from: a */
    private static C45061b m15554a(byte[][] bArr, int i) {
        AppMethodBeat.m2504i(57236);
        C45061b c45061b = new C45061b(bArr[0].length + (i * 2), bArr.length + (i * 2));
        c45061b.clear();
        int i2 = (c45061b.height - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr[i3][i4] == (byte) 1) {
                    c45061b.set(i4 + i, i2);
                }
            }
            i3++;
            i2--;
        }
        AppMethodBeat.m2505o(57236);
        return c45061b;
    }

    /* renamed from: a */
    private static byte[][] m15555a(byte[][] bArr) {
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
