package com.tencent.p177mm.plugin.p436hp.p437b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tinkerboots.sdk.C44598a;

/* renamed from: com.tencent.mm.plugin.hp.b.f */
public final class C6947f extends C4884c<C26111d> {
    private static long cbv = 0;

    public C6947f() {
        AppMethodBeat.m2504i(90607);
        this.xxI = C26111d.class.getName().hashCode();
        AppMethodBeat.m2505o(90607);
    }

    /* renamed from: a */
    private static boolean m11471a(C26111d c26111d) {
        AppMethodBeat.m2504i(138235);
        if (c26111d.crQ.crR) {
            AppMethodBeat.m2505o(138235);
        } else if (C1720g.m3531RK()) {
            if (cbv == 0) {
                cbv = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(0))).longValue();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - cbv >= 21600000 && C44598a.dWj() != null) {
                C44598a.dWj().mo71472rF(false);
                C4990ab.m7416i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
                cbv = currentTimeMillis;
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
            }
            AppMethodBeat.m2505o(138235);
        } else {
            AppMethodBeat.m2505o(138235);
        }
        return false;
    }

    /* renamed from: iT */
    public static void m11472iT(long j) {
        cbv = j;
    }
}
