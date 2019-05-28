package com.tencent.p177mm.p1099x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.x.c */
public final class C16112c implements C1816at {
    private static C16112c eFk;
    private C16107a eFl;

    private C16112c() {
        AppMethodBeat.m2504i(77749);
        if (C16107a.eEQ == null) {
            C16107a.eEQ = new C16107a();
        }
        this.eFl = C16107a.eEQ;
        AppMethodBeat.m2505o(77749);
    }

    /* renamed from: PJ */
    private static synchronized C16112c m24428PJ() {
        C16112c c16112c;
        synchronized (C16112c.class) {
            AppMethodBeat.m2504i(77750);
            if (eFk == null) {
                c16112c = new C16112c();
                eFk = c16112c;
                c16112c.eFl.init();
            }
            c16112c = eFk;
            AppMethodBeat.m2505o(77750);
        }
        return c16112c;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(77751);
        C16107a c16107a = this.eFl;
        c16107a.eES.clear();
        C30903b c30903b = c16107a.eER;
        C4990ab.m7410d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
        c30903b.eFa.clear();
        c30903b.eFc.clear();
        c30903b.eFb.clear();
        c30903b.eFd.clear();
        c16107a.initialized = false;
        AppMethodBeat.m2505o(77751);
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(77752);
        this.eFl.init();
        AppMethodBeat.m2505o(77752);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: PK */
    public static C16107a m24429PK() {
        AppMethodBeat.m2504i(77753);
        C1720g.m3534RN().mo5159QU();
        C16107a c16107a = C16112c.m24428PJ().eFl;
        AppMethodBeat.m2505o(77753);
        return c16107a;
    }
}
