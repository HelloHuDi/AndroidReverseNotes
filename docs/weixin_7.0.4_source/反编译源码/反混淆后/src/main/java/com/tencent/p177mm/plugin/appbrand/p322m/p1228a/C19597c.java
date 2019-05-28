package com.tencent.p177mm.plugin.appbrand.p322m.p1228a;

import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C27190b.C27191a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.m.a.c */
public final class C19597c {
    public final C38492q gMN;
    private final C27191a ipY;
    private final int ipZ;

    public C19597c(C38492q c38492q) {
        this.gMN = c38492q;
        this.ipZ = -1;
        this.ipY = null;
    }

    public C19597c(C38492q c38492q, int i, C27191a c27191a) {
        this.ipY = c27191a;
        this.gMN = c38492q;
        this.ipZ = i;
    }

    /* renamed from: B */
    public final String mo34803B(Map<String, Object> map) {
        AppMethodBeat.m2504i(102185);
        map.put("ret", Integer.valueOf(0));
        String CV = m30380CV(C19597c.m30379C(map));
        AppMethodBeat.m2505o(102185);
        return CV;
    }

    public final String aIU() {
        AppMethodBeat.m2504i(102186);
        HashMap hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(2));
        String CV = m30380CV(C19597c.m30379C(hashMap));
        AppMethodBeat.m2505o(102186);
        return CV;
    }

    /* renamed from: CV */
    private String m30380CV(String str) {
        AppMethodBeat.m2504i(102187);
        if (this.ipY == null) {
            AppMethodBeat.m2505o(102187);
            return str;
        }
        this.ipY.mo44860Y(this.ipZ, str);
        AppMethodBeat.m2505o(102187);
        return null;
    }

    /* renamed from: C */
    private static String m30379C(Map<String, Object> map) {
        AppMethodBeat.m2504i(102188);
        C32192i.m52509d(map);
        String c41726i = new C41726i((Map) map).toString();
        AppMethodBeat.m2505o(102188);
        return c41726i;
    }
}
