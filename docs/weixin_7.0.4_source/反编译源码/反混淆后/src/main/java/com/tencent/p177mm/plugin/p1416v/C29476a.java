package com.tencent.p177mm.plugin.p1416v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C6616b;
import com.tencent.p177mm.kernel.p241b.C6617c;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.v.a */
public final class C29476a implements C6616b, C6617c {
    private static C29476a pLk;

    private C29476a() {
    }

    public final List<String> collectStoragePaths() {
        return null;
    }

    public static synchronized C29476a ceU() {
        C29476a c29476a;
        synchronized (C29476a.class) {
            AppMethodBeat.m2504i(136942);
            if (pLk == null) {
                pLk = new C29476a();
            }
            c29476a = pLk;
            AppMethodBeat.m2505o(136942);
        }
        return c29476a;
    }

    public static String ceV() {
        AppMethodBeat.m2504i(136943);
        String str = C1720g.m3536RP().eJM + "remark/";
        AppMethodBeat.m2505o(136943);
        return str;
    }
}
