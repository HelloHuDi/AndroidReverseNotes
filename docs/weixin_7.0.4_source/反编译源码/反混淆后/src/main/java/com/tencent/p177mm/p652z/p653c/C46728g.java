package com.tencent.p177mm.p652z.p653c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p1101b.C30908e;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.z.c.g */
public final class C46728g {
    private final Map<String, C30908e> eIx = new HashMap();

    public C46728g() {
        AppMethodBeat.m2504i(115319);
        AppMethodBeat.m2505o(115319);
    }

    /* renamed from: a */
    public final void mo75145a(C30908e c30908e) {
        AppMethodBeat.m2504i(115320);
        this.eIx.put(c30908e.getName(), c30908e);
        AppMethodBeat.m2505o(115320);
    }

    /* renamed from: lq */
    public final C30908e mo75146lq(String str) {
        AppMethodBeat.m2504i(115321);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(115321);
            return null;
        }
        C30908e c30908e = (C30908e) this.eIx.get(str);
        AppMethodBeat.m2505o(115321);
        return c30908e;
    }
}
