package com.tencent.p177mm.plugin.bottle.p924a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7310be.C5132a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.bottle.a.d */
public final class C45759d implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C5132a flN = new C457582();
    private C45757b jJM;

    /* renamed from: com.tencent.mm.plugin.bottle.a.d$1 */
    static class C111841 implements C1366d {
        C111841() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C45757b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bottle.a.d$2 */
    class C457582 implements C5132a {
        C457582() {
        }

        /* renamed from: a */
        public final void mo10531a(C7617ak c7617ak, C7310be c7310be) {
            AppMethodBeat.m2504i(18537);
            if (c7617ak == null) {
                AppMethodBeat.m2505o(18537);
            } else if ("_USER_FOR_THROWBOTTLE_".equals(c7617ak.field_username)) {
                c7617ak.setUsername("");
                AppMethodBeat.m2505o(18537);
            } else {
                if (!(1 == c7617ak.field_isSend || !C7616ad.m13548mR(c7617ak.field_username) || c7310be.mo15766MV(c7617ak.field_username))) {
                    C38676c.m65605FA(c7617ak.field_username);
                }
                AppMethodBeat.m2505o(18537);
            }
        }
    }

    public C45759d() {
        AppMethodBeat.m2504i(18538);
        AppMethodBeat.m2505o(18538);
    }

    private static C45759d aVL() {
        AppMethodBeat.m2504i(18539);
        C9638aw.m17184ZE();
        C45759d c45759d = (C45759d) C45439bw.m83697oJ("plugin.bottle");
        if (c45759d == null) {
            c45759d = new C45759d();
            C9638aw.m17184ZE().mo73244a("plugin.bottle", c45759d);
        }
        AppMethodBeat.m2505o(18539);
        return c45759d;
    }

    public static C45757b aVM() {
        AppMethodBeat.m2504i(18540);
        C1720g.m3534RN().mo5159QU();
        if (C45759d.aVL().jJM == null) {
            C45759d aVL = C45759d.aVL();
            C9638aw.m17190ZK();
            aVL.jJM = new C45757b(C18628c.m29069Ru());
        }
        C45757b c45757b = C45759d.aVL().jJM;
        AppMethodBeat.m2505o(18540);
        return c45757b;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(18541);
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo15808d(this.flN);
        AppMethodBeat.m2505o(18541);
    }

    static {
        AppMethodBeat.m2504i(18543);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("THROWBOTTLEINFO_TABLE".hashCode()), new C111841());
        AppMethodBeat.m2505o(18543);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(18542);
        C38676c.aVK();
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo15805c(this.flN);
        AppMethodBeat.m2505o(18542);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }
}
