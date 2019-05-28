package com.tencent.p177mm.plugin.appbrand.p322m.p323c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.p321l.C19538j;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C19597c;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42626d;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.m.c.c */
public final class C38440c extends C42626d {
    /* renamed from: b */
    public final String mo61136b(C41726i c41726i, C19597c c19597c) {
        AppMethodBeat.m2504i(102194);
        String str = (String) C19538j.m30258CP(c41726i.optString("url")).get("host");
        HashMap hashMap = new HashMap();
        hashMap.put("isLANIp", Boolean.valueOf(C19538j.m30260CR(str) == 2));
        str = c19597c.mo34803B(hashMap);
        AppMethodBeat.m2505o(102194);
        return str;
    }

    public final int aIT() {
        return 6;
    }
}
