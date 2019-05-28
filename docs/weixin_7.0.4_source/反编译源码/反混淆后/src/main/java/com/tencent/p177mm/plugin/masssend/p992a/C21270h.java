package com.tencent.p177mm.plugin.masssend.p992a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.masssend.a.h */
public final class C21270h implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C1837a olc = new C124892();
    private C46069b ooi;
    private C43293c ooj;
    private C43294i ook = new C43294i();
    private C34521g ool = new C34521g();

    /* renamed from: com.tencent.mm.plugin.masssend.a.h$2 */
    class C124892 implements C1837a {
        C124892() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(22744);
            String a = C1946aa.m4148a(c1197a.eAB.vED);
            C4990ab.m7416i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:".concat(String.valueOf(a)));
            C21270h.bNF().mo68839Qt(a);
            C21270h.bNF().bNA();
            C21270h.bNF();
            C43293c.m77162je(C5046bo.anU());
            AppMethodBeat.m2505o(22744);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.a.h$1 */
    static class C212711 implements C1366d {
        C212711() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46069b.fnj;
        }
    }

    public C21270h() {
        AppMethodBeat.m2504i(22745);
        AppMethodBeat.m2505o(22745);
    }

    private static C21270h bND() {
        AppMethodBeat.m2504i(22746);
        C9638aw.m17184ZE();
        C21270h c21270h = (C21270h) C45439bw.m83697oJ("plugin.masssend");
        if (c21270h == null) {
            c21270h = new C21270h();
            C9638aw.m17184ZE().mo73244a("plugin.favorite", c21270h);
        }
        AppMethodBeat.m2505o(22746);
        return c21270h;
    }

    public static C46069b bNE() {
        AppMethodBeat.m2504i(22747);
        C1720g.m3534RN().mo5159QU();
        if (C21270h.bND().ooi == null) {
            C21270h bND = C21270h.bND();
            C9638aw.m17190ZK();
            bND.ooi = new C46069b(C18628c.m29069Ru());
        }
        C46069b c46069b = C21270h.bND().ooi;
        AppMethodBeat.m2505o(22747);
        return c46069b;
    }

    public static C43293c bNF() {
        AppMethodBeat.m2504i(22748);
        if (C21270h.bND().ooj == null) {
            C21270h.bND().ooj = new C43293c();
        }
        C43293c c43293c = C21270h.bND().ooj;
        AppMethodBeat.m2505o(22748);
        return c43293c;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(22749);
        C9638aw.getSysCmdMsgExtension().mo14903b("masssendapp", this.olc, false);
        C4879a.xxA.mo10053d(this.ook);
        C4879a.xxA.mo10053d(this.ool);
        AppMethodBeat.m2505o(22749);
    }

    static {
        AppMethodBeat.m2504i(22751);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("MASSENDINFO_TABLE".hashCode()), new C212711());
        AppMethodBeat.m2505o(22751);
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
        AppMethodBeat.m2504i(22750);
        C9638aw.getSysCmdMsgExtension().mo14900a("masssendapp", this.olc, false);
        C4879a.xxA.mo10052c(this.ook);
        C4879a.xxA.mo10052c(this.ool);
        AppMethodBeat.m2505o(22750);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }
}
