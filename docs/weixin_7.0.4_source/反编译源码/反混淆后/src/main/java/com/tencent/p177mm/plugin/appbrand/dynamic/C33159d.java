package com.tencent.p177mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d */
public class C33159d {
    private static volatile C33159d hlw;
    Map<String, C38195c> hlx = new ConcurrentHashMap();

    private C33159d() {
        AppMethodBeat.m2504i(10675);
        AppMethodBeat.m2505o(10675);
    }

    public static C33159d azy() {
        AppMethodBeat.m2504i(10676);
        if (hlw == null) {
            synchronized (C33159d.class) {
                try {
                    if (hlw == null) {
                        hlw = new C33159d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10676);
                    }
                }
            }
        }
        C33159d c33159d = hlw;
        AppMethodBeat.m2505o(10676);
        return c33159d;
    }

    /* renamed from: zR */
    public final C38195c mo53689zR(String str) {
        AppMethodBeat.m2504i(10677);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
            AppMethodBeat.m2505o(10677);
            return null;
        }
        C38195c c38195c = (C38195c) this.hlx.get(str);
        AppMethodBeat.m2505o(10677);
        return c38195c;
    }
}
