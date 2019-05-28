package com.tencent.p177mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.exdevice.service.v */
public final class C20549v {
    private static C20549v lwR = null;
    public C5004al fPG = new C5004al();
    final HashMap<Long, Integer> lwS = new HashMap();

    private C20549v() {
        AppMethodBeat.m2504i(19630);
        AppMethodBeat.m2505o(19630);
    }

    public static C20549v bpz() {
        AppMethodBeat.m2504i(19631);
        if (lwR == null) {
            lwR = new C20549v();
        }
        C20549v c20549v = lwR;
        AppMethodBeat.m2505o(19631);
        return c20549v;
    }
}
