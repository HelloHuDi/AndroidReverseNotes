package com.tencent.p177mm.model.p1207a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

/* renamed from: com.tencent.mm.model.a.b */
public final class C45435b {
    public String eyp;
    public String fnS;
    public String fnT;
    public String fnU;
    public HashMap<String, C42183e> fnV = new HashMap();

    public C45435b() {
        AppMethodBeat.m2504i(118140);
        AppMethodBeat.m2505o(118140);
    }

    /* renamed from: oP */
    public final C42183e mo73237oP(String str) {
        AppMethodBeat.m2504i(118141);
        if (this.fnV == null || !this.fnV.containsKey(str)) {
            AppMethodBeat.m2505o(118141);
            return null;
        }
        C42183e c42183e = (C42183e) this.fnV.get(str);
        AppMethodBeat.m2505o(118141);
        return c42183e;
    }
}
