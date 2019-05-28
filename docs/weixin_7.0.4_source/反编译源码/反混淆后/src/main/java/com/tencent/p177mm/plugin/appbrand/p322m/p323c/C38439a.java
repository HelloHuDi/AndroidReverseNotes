package com.tencent.p177mm.plugin.appbrand.p322m.p323c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C19597c;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42626d;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.m.c.a */
public final class C38439a extends C42626d {
    public final int aIT() {
        return 2;
    }

    /* renamed from: b */
    public final String mo61136b(C41726i c41726i, C19597c c19597c) {
        AppMethodBeat.m2504i(102192);
        C38492q c38492q = c19597c.gMN;
        HashMap hashMap = new HashMap();
        hashMap.put("state", Integer.valueOf(c38492q.getRuntime().gNN.gWy.awz().ordinal()));
        String B = c19597c.mo34803B(hashMap);
        AppMethodBeat.m2505o(102192);
        return B;
    }
}
