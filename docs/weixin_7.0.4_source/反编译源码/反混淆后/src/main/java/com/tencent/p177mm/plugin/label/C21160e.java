package com.tencent.p177mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1184av.C45175b;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.storage.C40622ai;
import com.tencent.p177mm.storage.C46620ah;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.label.e */
public class C21160e implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C40622ai nHt;
    private C21159d nHu = new C21159d();

    /* renamed from: com.tencent.mm.plugin.label.e$2 */
    static class C123402 implements C1366d {
        C123402() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46620ah.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.e$1 */
    static class C211611 implements C1366d {
        C211611() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C40622ai.fnj;
        }
    }

    public C21160e() {
        AppMethodBeat.m2504i(22514);
        AppMethodBeat.m2505o(22514);
    }

    static {
        AppMethodBeat.m2504i(22519);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new C211611());
        eaA.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new C123402());
        AppMethodBeat.m2505o(22519);
    }

    private static C21160e bIY() {
        AppMethodBeat.m2504i(22515);
        C9638aw.m17184ZE();
        C21160e c21160e = (C21160e) C45439bw.m83697oJ("plugin.label");
        if (c21160e == null) {
            synchronized (C21160e.class) {
                if (c21160e == null) {
                    try {
                        c21160e = new C21160e();
                        C9638aw.m17184ZE().mo73244a("plugin.label", c21160e);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(22515);
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(22515);
        return c21160e;
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
        AppMethodBeat.m2504i(22516);
        C43239b c43239b = new C43239b();
        C21156a.nHv = c43239b;
        C45175b.fHH = c43239b;
        C4879a.xxA.mo10052c(this.nHu);
        AppMethodBeat.m2505o(22516);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(22517);
        C21156a.nHv = null;
        C4879a.xxA.mo10053d(this.nHu);
        AppMethodBeat.m2505o(22517);
    }

    public static C40622ai bIZ() {
        AppMethodBeat.m2504i(22518);
        C1720g.m3534RN().mo5159QU();
        if (C21160e.bIY().nHt == null) {
            C21160e bIY = C21160e.bIY();
            C9638aw.m17190ZK();
            bIY.nHt = new C40622ai(C18628c.m29069Ru());
        }
        C40622ai c40622ai = C21160e.bIY().nHt;
        AppMethodBeat.m2505o(22518);
        return c40622ai;
    }
}
