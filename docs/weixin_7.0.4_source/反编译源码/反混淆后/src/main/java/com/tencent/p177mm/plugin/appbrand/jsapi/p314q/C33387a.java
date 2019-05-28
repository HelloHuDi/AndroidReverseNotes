package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C16674d.C16675a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.a */
public final class C33387a extends C38369p {
    private static final int CTRL_INDEX = 153;
    private static final String NAME = "onNetworkStatusChange";
    private static C33387a hXw;

    /* renamed from: k */
    public static synchronized void m54580k(C2241c c2241c) {
        synchronized (C33387a.class) {
            AppMethodBeat.m2504i(86976);
            HashMap hashMap = new HashMap();
            C16675a cK = C16674d.m25680cK(C4996ah.getContext());
            hashMap.put("isConnected", Boolean.valueOf(cK != C16675a.None));
            hashMap.put("networkType", cK.value);
            if (hXw == null) {
                hXw = new C33387a();
            }
            hXw.mo61031i(c2241c).mo34958t(hashMap).aCj();
            AppMethodBeat.m2505o(86976);
        }
    }
}
