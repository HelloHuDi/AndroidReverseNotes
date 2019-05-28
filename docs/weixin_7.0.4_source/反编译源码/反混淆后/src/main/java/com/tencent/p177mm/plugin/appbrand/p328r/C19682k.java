package com.tencent.p177mm.plugin.appbrand.p328r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.r.k */
public final class C19682k {
    /* renamed from: a */
    public static <T extends C1331a> boolean m30480a(T t, T t2) {
        boolean z = false;
        AppMethodBeat.m2504i(57066);
        if (t == null && t2 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("both null!!!");
            AppMethodBeat.m2505o(57066);
            throw illegalArgumentException;
        }
        if (t == null) {
            AppMethodBeat.m2505o(57066);
        } else if (t2 == null) {
            AppMethodBeat.m2505o(57066);
        } else {
            try {
                z = C5046bo.isEqual(t.toByteArray(), t2.toByteArray());
                AppMethodBeat.m2505o(57066);
            } catch (Exception e) {
                AppMethodBeat.m2505o(57066);
            }
        }
        return z;
    }
}
