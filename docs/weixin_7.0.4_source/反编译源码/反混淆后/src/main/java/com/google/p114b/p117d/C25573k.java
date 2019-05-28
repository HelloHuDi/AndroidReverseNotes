package com.google.p114b.p117d;

import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.google.b.d.k */
public final class C25573k extends C41641r {
    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57227);
        if (c37292a != C37292a.EAN_8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57227);
            throw illegalArgumentException;
        }
        C45061b a = super.mo3688a(str, c37292a, i, i2, map);
        AppMethodBeat.m2505o(57227);
        return a;
    }

    /* renamed from: bj */
    public final boolean[] mo3687bj(String str) {
        AppMethodBeat.m2504i(57228);
        if (str.length() != 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
            AppMethodBeat.m2505o(57228);
            throw illegalArgumentException;
        }
        int i;
        boolean[] zArr = new boolean[67];
        int a = C45065o.m82688a(zArr, 0, C41640q.bAC, true) + 0;
        for (i = 0; i <= 3; i++) {
            a += C45065o.m82688a(zArr, a, C41640q.bAE[Integer.parseInt(str.substring(i, i + 1))], false);
        }
        int a2 = a + C45065o.m82688a(zArr, a, C41640q.bAD, false);
        for (i = 4; i <= 7; i++) {
            a2 += C45065o.m82688a(zArr, a2, C41640q.bAE[Integer.parseInt(str.substring(i, i + 1))], true);
        }
        C45065o.m82688a(zArr, a2, C41640q.bAC, true);
        AppMethodBeat.m2505o(57228);
        return zArr;
    }
}
