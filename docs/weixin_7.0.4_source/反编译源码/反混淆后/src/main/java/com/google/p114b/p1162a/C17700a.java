package com.google.p114b.p1162a;

import com.google.p114b.C25577g;
import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p1162a.p1163a.C17698a;
import com.google.p114b.p1162a.p1163a.C25571c;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.Map;

/* renamed from: com.google.b.a.a */
public final class C17700a implements C25577g {
    private static final Charset byj = Charset.forName("ISO-8859-1");

    static {
        AppMethodBeat.m2504i(57191);
        AppMethodBeat.m2505o(57191);
    }

    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57189);
        Charset charset = byj;
        int i3 = 33;
        int i4 = 0;
        if (map != null) {
            if (map.containsKey(C41638c.CHARACTER_SET)) {
                charset = Charset.forName(map.get(C41638c.CHARACTER_SET).toString());
            }
            if (map.containsKey(C41638c.ERROR_CORRECTION)) {
                i3 = Integer.parseInt(map.get(C41638c.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(C41638c.AZTEC_LAYERS)) {
                i4 = Integer.parseInt(map.get(C41638c.AZTEC_LAYERS).toString());
            }
        }
        if (c37292a != C37292a.AZTEC) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57189);
            throw illegalArgumentException;
        }
        C45061b a = C17700a.m27627a(C25571c.m40543n(str.getBytes(charset), i3, i4), i, i2);
        AppMethodBeat.m2505o(57189);
        return a;
    }

    /* renamed from: a */
    private static C45061b m27627a(C17698a c17698a, int i, int i2) {
        AppMethodBeat.m2504i(57190);
        C45061b c45061b = c17698a.byn;
        if (c45061b == null) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.m2505o(57190);
            throw illegalStateException;
        }
        int i3 = c45061b.width;
        int i4 = c45061b.height;
        int max = Math.max(i, i3);
        int max2 = Math.max(i2, i4);
        int min = Math.min(max / i3, max2 / i4);
        int i5 = (max - (i3 * min)) / 2;
        int i6 = (max2 - (i4 * min)) / 2;
        C45061b c45061b2 = new C45061b(max, max2);
        max2 = i6;
        for (int i7 = 0; i7 < i4; i7++) {
            i6 = i5;
            max = 0;
            while (max < i3) {
                if (c45061b.mo72817bB(max, i7)) {
                    c45061b2.mo72822p(i6, max2, min, min);
                }
                max++;
                i6 += min;
            }
            max2 += min;
        }
        AppMethodBeat.m2505o(57190);
        return c45061b2;
    }
}
