package com.google.p114b.p117d;

import com.google.p114b.C25576d;
import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.google.b.d.j */
public final class C32084j extends C41641r {
    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57326);
        if (c37292a != C37292a.EAN_13) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57326);
            throw illegalArgumentException;
        }
        C45061b a = super.mo3688a(str, c37292a, i, i2, map);
        AppMethodBeat.m2505o(57326);
        return a;
    }

    /* renamed from: bj */
    public final boolean[] mo3687bj(String str) {
        AppMethodBeat.m2504i(57327);
        IllegalArgumentException illegalArgumentException;
        if (str.length() != 13) {
            illegalArgumentException = new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
            AppMethodBeat.m2505o(57327);
            throw illegalArgumentException;
        }
        try {
            if (C41640q.m73000r(str)) {
                int i;
                int parseInt;
                int i2 = C37299i.bAv[Integer.parseInt(str.substring(0, 1))];
                boolean[] zArr = new boolean[95];
                int a = C45065o.m82688a(zArr, 0, C41640q.bAC, true) + 0;
                for (i = 1; i <= 6; i++) {
                    parseInt = Integer.parseInt(str.substring(i, i + 1));
                    if (((i2 >> (6 - i)) & 1) == 1) {
                        parseInt += 10;
                    }
                    a += C45065o.m82688a(zArr, a, C41640q.bAF[parseInt], false);
                }
                i = a + C45065o.m82688a(zArr, a, C41640q.bAD, false);
                for (parseInt = 7; parseInt <= 12; parseInt++) {
                    i += C45065o.m82688a(zArr, i, C41640q.bAE[Integer.parseInt(str.substring(parseInt, parseInt + 1))], true);
                }
                C45065o.m82688a(zArr, i, C41640q.bAC, true);
                AppMethodBeat.m2505o(57327);
                return zArr;
            }
            illegalArgumentException = new IllegalArgumentException("Contents do not pass checksum");
            AppMethodBeat.m2505o(57327);
            throw illegalArgumentException;
        } catch (C25576d e) {
            illegalArgumentException = new IllegalArgumentException("Illegal contents");
            AppMethodBeat.m2505o(57327);
            throw illegalArgumentException;
        }
    }
}
