package com.google.p114b.p120f;

import com.google.p114b.C25577g;
import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p120f.p121a.C32089a;
import com.google.p114b.p120f.p122b.C0906c;
import com.google.p114b.p120f.p122b.C45066f;
import com.google.p114b.p120f.p122b.C8738b;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.google.b.f.a */
public final class C31250a implements C25577g {
    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57258);
        IllegalArgumentException illegalArgumentException;
        if (str.isEmpty()) {
            illegalArgumentException = new IllegalArgumentException("Found empty contents");
            AppMethodBeat.m2505o(57258);
            throw illegalArgumentException;
        } else if (c37292a != C37292a.QR_CODE) {
            illegalArgumentException = new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57258);
            throw illegalArgumentException;
        } else if (i < 0 || i2 < 0) {
            illegalArgumentException = new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
            AppMethodBeat.m2505o(57258);
            throw illegalArgumentException;
        } else {
            C32089a c32089a = C32089a.L;
            int i3 = 4;
            if (map != null) {
                if (map.containsKey(C41638c.ERROR_CORRECTION)) {
                    c32089a = C32089a.valueOf(map.get(C41638c.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(C41638c.MARGIN)) {
                    i3 = Integer.parseInt(map.get(C41638c.MARGIN).toString());
                }
            }
            C45061b a = C31250a.m50416a(C0906c.m2059a(str, c32089a, (Map) map), i, i2, i3);
            AppMethodBeat.m2505o(57258);
            return a;
        }
    }

    /* renamed from: a */
    private static C45061b m50416a(C45066f c45066f, int i, int i2, int i3) {
        AppMethodBeat.m2504i(57259);
        C8738b c8738b = c45066f.bBU;
        if (c8738b == null) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.m2505o(57259);
            throw illegalStateException;
        }
        int i4 = c8738b.width;
        int i5 = c8738b.height;
        int i6 = (i3 << 1) + i4;
        int i7 = (i3 << 1) + i5;
        int max = Math.max(i, i6);
        int max2 = Math.max(i2, i7);
        int min = Math.min(max / i6, max2 / i7);
        i7 = (max - (i4 * min)) / 2;
        i6 = (max2 - (i5 * min)) / 2;
        C45061b c45061b = new C45061b(max, max2);
        max2 = i6;
        for (int i8 = 0; i8 < i5; i8++) {
            max = 0;
            i6 = i7;
            while (max < i4) {
                if (c8738b.mo19752bH(max, i8) == (byte) 1) {
                    c45061b.mo72822p(i6, max2, min, min);
                }
                max++;
                i6 += min;
            }
            max2 += min;
        }
        AppMethodBeat.m2505o(57259);
        return c45061b;
    }
}
