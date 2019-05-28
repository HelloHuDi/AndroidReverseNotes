package com.tencent.p177mm.plugin.p1140r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p199ax.C1301c;
import com.tencent.p177mm.p199ax.C32321b;
import com.tencent.p177mm.p199ax.C6328d;
import com.tencent.p177mm.p199ax.C6330f;
import com.tencent.p177mm.p199ax.C9061e;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C30297bn;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.r.a */
public final class C16841a extends C7485q implements C18523a, C9562c {
    private static HashMap<Integer, C1366d> eaA;
    private static C16841a oSU;
    private C6328d oSV = null;
    private C30297bn oSW = null;
    private C1301c oSX = null;
    private C9061e oSY = new C9061e();
    private final C1202f oSZ = new C168431();

    /* renamed from: com.tencent.mm.plugin.r.a$2 */
    static class C168422 implements C1366d {
        C168422() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C30297bn.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.r.a$1 */
    class C168431 implements C1202f {
        C168431() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        }
    }

    private C16841a() {
        super(C6330f.class);
        AppMethodBeat.m2504i(79106);
        AppMethodBeat.m2505o(79106);
    }

    public static synchronized C16841a bVs() {
        C16841a c16841a;
        synchronized (C16841a.class) {
            AppMethodBeat.m2504i(79107);
            if (oSU == null) {
                oSU = new C16841a();
            }
            c16841a = oSU;
            AppMethodBeat.m2505o(79107);
        }
        return c16841a;
    }

    static {
        AppMethodBeat.m2504i(79113);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("NEWTIPS_TABLE".hashCode()), new C168422());
        AppMethodBeat.m2505o(79113);
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(79108);
        super.onAccountInitialized(c1705c);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14901a("newtips", this.oSY);
        C1720g.m3540Rg().mo14539a(597, this.oSZ);
        C16841a.bVt();
        C6328d.m10411b(C32321b.fKD, C32321b.fKC, "", C32321b.fKK);
        C4990ab.m7417i("MicroMsg.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", Integer.valueOf(r0), r1);
        AppMethodBeat.m2505o(79108);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(79109);
        super.onAccountRelease();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14904b("newtips", this.oSY);
        C1720g.m3540Rg().mo14546b(597, this.oSZ);
        AppMethodBeat.m2505o(79109);
    }

    public static C6328d bVt() {
        AppMethodBeat.m2504i(79110);
        C1720g.m3534RN().mo5159QU();
        if (C16841a.bVs().oSV == null) {
            C16841a.bVs().oSV = new C6328d();
        }
        C6328d c6328d = C16841a.bVs().oSV;
        AppMethodBeat.m2505o(79110);
        return c6328d;
    }

    public static C30297bn bVu() {
        AppMethodBeat.m2504i(79111);
        C1720g.m3534RN().mo5159QU();
        if (C16841a.bVs().oSW == null) {
            C16841a bVs = C16841a.bVs();
            C1720g.m3537RQ();
            bVs.oSW = new C30297bn(C1720g.m3536RP().eJN);
        }
        C30297bn c30297bn = C16841a.bVs().oSW;
        AppMethodBeat.m2505o(79111);
        return c30297bn;
    }

    public static C1301c bVv() {
        AppMethodBeat.m2504i(79112);
        C1720g.m3534RN().mo5159QU();
        if (C16841a.bVs().oSX == null) {
            C16841a.bVs().oSX = new C1301c();
        }
        C1301c c1301c = C16841a.bVs().oSX;
        AppMethodBeat.m2505o(79112);
        return c1301c;
    }

    public final HashMap<Integer, C1366d> collectDatabaseFactory() {
        return eaA;
    }
}
