package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.p321l.C42603p.C42605c;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.a */
public final class C10432a extends C42467ah {
    private static final int CTRL_INDEX = 530;
    private static final String NAME = "onLocalServiceEvent";
    private static C10432a hRp = new C10432a();

    static {
        AppMethodBeat.m2504i(108018);
        AppMethodBeat.m2505o(108018);
    }

    /* renamed from: a */
    public static void m18156a(C2241c c2241c, C42605c c42605c) {
        AppMethodBeat.m2504i(108013);
        C10432a.m18157a(c2241c, c42605c, "found");
        AppMethodBeat.m2505o(108013);
    }

    /* renamed from: b */
    public static void m18158b(C2241c c2241c, C42605c c42605c) {
        AppMethodBeat.m2504i(108014);
        C10432a.m18157a(c2241c, c42605c, "lost");
        AppMethodBeat.m2505o(108014);
    }

    /* renamed from: c */
    public static void m18159c(C2241c c2241c, C42605c c42605c) {
        AppMethodBeat.m2504i(108015);
        C10432a.m18157a(c2241c, c42605c, "resolveFail");
        AppMethodBeat.m2505o(108015);
    }

    /* renamed from: r */
    public static void m18160r(C2241c c2241c) {
        AppMethodBeat.m2504i(108016);
        C10432a.m18157a(c2241c, null, "stopScan");
        AppMethodBeat.m2505o(108016);
    }

    /* renamed from: a */
    private static synchronized void m18157a(C2241c c2241c, C42605c c42605c, String str) {
        synchronized (C10432a.class) {
            AppMethodBeat.m2504i(108017);
            HashMap hashMap = new HashMap();
            hashMap.put("event", str);
            if (TextUtils.equals(str, "found") || TextUtils.equals(str, "lost") || TextUtils.equals(str, "resolveFail")) {
                hashMap.put("serviceType", c42605c.ipA);
                hashMap.put("serviceName", c42605c.ipz);
                if (!TextUtils.equals(str, "resolveFail")) {
                    hashMap.put("ip", c42605c.f17184ip);
                    hashMap.put("port", Integer.valueOf(c42605c.port));
                    hashMap.put("attributes", c42605c.ipy);
                }
            }
            hRp.mo34958t(hashMap).mo61032j(c2241c).aCj();
            AppMethodBeat.m2505o(108017);
        }
    }
}
