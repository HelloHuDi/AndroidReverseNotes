package com.tencent.p177mm.model.p1207a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.model.a.g */
public class C26407g implements C1816at {
    private C37900c foc = null;

    private static C26407g aaJ() {
        AppMethodBeat.m2504i(118151);
        C26407g c26407g = (C26407g) C7485q.m12925Y(C26407g.class);
        AppMethodBeat.m2505o(118151);
        return c26407g;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(118152);
        C37900c aaK = C26407g.aaK();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            aaK.mo60655oQ((String) C1720g.m3536RP().mo5239Ry().get(328193, null));
            if (aaK.aaI()) {
                C18608f.m29043oS(aaK.fnW.fnS);
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", e.toString());
        }
        C4990ab.m7417i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(118152);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(118153);
        C37900c aaK = C26407g.aaK();
        aaK.fnX = null;
        aaK.fnW = null;
        AppMethodBeat.m2505o(118153);
    }

    public static C37900c aaK() {
        AppMethodBeat.m2504i(118154);
        C1720g.m3534RN().mo5159QU();
        if (C26407g.aaJ().foc == null) {
            C26407g.aaJ().foc = new C37900c();
        }
        C37900c c37900c = C26407g.aaJ().foc;
        AppMethodBeat.m2505o(118154);
        return c37900c;
    }
}
