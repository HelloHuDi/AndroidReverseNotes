package com.tencent.p177mm.plugin.appbrand.p322m.p323c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C19597c;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C27190b;
import com.tencent.p177mm.plugin.appbrand.permission.C38487d;
import com.tencent.p177mm.plugin.appbrand.permission.C38487d.C2430b;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.m.c.g */
public final class C31323g extends C27190b {
    public final int aIT() {
        return 1;
    }

    /* renamed from: a */
    public final void mo22138a(C41726i c41726i, final C19597c c19597c) {
        AppMethodBeat.m2504i(102201);
        String optString = c41726i.optString("apiName");
        C33327h c33327h = c19597c.gMN;
        if (C38487d.m65129cK(c33327h.getAppId(), optString)) {
            C31323g.m50597a(c19597c, 1);
            AppMethodBeat.m2505o(102201);
            return;
        }
        C38487d.m65122a(c33327h, optString, new C2430b() {
            public final void aIX() {
                AppMethodBeat.m2504i(102198);
                C31323g.m50597a(c19597c, 1);
                AppMethodBeat.m2505o(102198);
            }

            /* renamed from: CW */
            public final void mo6342CW(String str) {
                AppMethodBeat.m2504i(102199);
                C31323g.m50597a(c19597c, 2);
                AppMethodBeat.m2505o(102199);
            }

            public final void onCancel() {
                AppMethodBeat.m2504i(102200);
                C31323g.m50597a(c19597c, 3);
                AppMethodBeat.m2505o(102200);
            }
        });
        AppMethodBeat.m2505o(102201);
    }

    /* renamed from: a */
    static void m50597a(C19597c c19597c, int i) {
        AppMethodBeat.m2504i(102202);
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(i));
        c19597c.mo34803B(hashMap);
        AppMethodBeat.m2505o(102202);
    }
}
