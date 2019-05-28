package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s */
public final class C19475s extends C38369p {
    private static final int CTRL_INDEX = 248;
    private static final String NAME = "onUserCaptureScreen";
    private static C19475s hwm = new C19475s();

    static {
        AppMethodBeat.m2504i(86965);
        AppMethodBeat.m2505o(86965);
    }

    /* renamed from: k */
    public static void m30162k(C2241c c2241c) {
        AppMethodBeat.m2504i(86964);
        C4990ab.m7417i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", c2241c.getAppId());
        hwm.mo61031i(c2241c).aCj();
        AppMethodBeat.m2505o(86964);
    }
}
