package com.tencent.p177mm.plugin.record.p492b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.record.p1016a.C43428e;
import com.tencent.p177mm.plugin.record.p1016a.C43429f;
import com.tencent.p177mm.plugin.record.p1016a.C46163g;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.record.b.t */
public final class C46165t implements C1816at {
    private static HashMap<Integer, C1366d> eaA;

    /* renamed from: com.tencent.mm.plugin.record.b.t$1 */
    static class C216141 implements C1366d {
        C216141() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46163g.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.b.t$2 */
    static class C434372 implements C1366d {
        C434372() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C43428e.fnj;
        }
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    static {
        AppMethodBeat.m2504i(24189);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new C216141());
        eaA.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new C434372());
        AppMethodBeat.m2505o(24189);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(24188);
        C1720g.m3542a(C43429f.class, new C44757k());
        AppMethodBeat.m2505o(24188);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
