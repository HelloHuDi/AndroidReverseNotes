package com.google.p114b.p117d;

import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.google.b.d.t */
public final class C25575t extends C41641r {
    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57155);
        if (c37292a != C37292a.UPC_E) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57155);
            throw illegalArgumentException;
        }
        C45061b a = super.mo3688a(str, c37292a, i, i2, map);
        AppMethodBeat.m2505o(57155);
        return a;
    }

    /* renamed from: bj */
    public final boolean[] mo3687bj(String str) {
        AppMethodBeat.m2504i(57156);
        if (str.length() != 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
            AppMethodBeat.m2505o(57156);
            throw illegalArgumentException;
        }
        int i = C17702s.bAG[Integer.parseInt(str.substring(7, 8))];
        boolean[] zArr = new boolean[51];
        int a = C45065o.m82688a(zArr, 0, C41640q.bAC, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int parseInt = Integer.parseInt(str.substring(i2, i2 + 1));
            if (((i >> (6 - i2)) & 1) == 1) {
                parseInt += 10;
            }
            a += C45065o.m82688a(zArr, a, C41640q.bAF[parseInt], false);
        }
        C45065o.m82688a(zArr, a, C41640q.bAA, false);
        AppMethodBeat.m2505o(57156);
        return zArr;
    }
}
