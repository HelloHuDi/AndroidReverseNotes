package com.tencent.p177mm.plugin.voip_cs.p547b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C6460bj;
import com.tencent.p177mm.p230g.p231a.C6460bj.C6461a;
import com.tencent.p177mm.plugin.voip_cs.p1309a.C22485a;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1310b.C43747a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.c */
public class C43749c implements C1816at {
    private static C43749c tcF = null;
    private C43747a tcG = new C43747a();
    private C22488e tcH = new C22488e();
    private C43750d tcI = new C43750d();
    private C22485a tcJ = new C22485a();
    private C4884c tcK = new C295221();

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.c$1 */
    class C295221 extends C4884c<C6460bj> {
        C295221() {
            AppMethodBeat.m2504i(135288);
            this.xxI = C6460bj.class.getName().hashCode();
            AppMethodBeat.m2505o(135288);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            boolean z = true;
            AppMethodBeat.m2504i(135289);
            C6460bj c6460bj = (C6460bj) c4883b;
            if (c6460bj instanceof C6460bj) {
                C6461a c6461a = c6460bj.cuD;
                if (!(C43749c.cMf().tdM == 1 || C43749c.cMf().tdM == 2)) {
                    z = false;
                }
                c6461a.aFV = z;
            }
            AppMethodBeat.m2505o(135289);
            return false;
        }
    }

    public C43749c() {
        AppMethodBeat.m2504i(135290);
        AppMethodBeat.m2505o(135290);
    }

    private static C43749c cMd() {
        AppMethodBeat.m2504i(135291);
        C43749c c43749c = (C43749c) C7485q.m12925Y(C43749c.class);
        AppMethodBeat.m2505o(135291);
        return c43749c;
    }

    public static C43747a cMe() {
        AppMethodBeat.m2504i(135292);
        C43747a c43747a = C43749c.cMd().tcG;
        AppMethodBeat.m2505o(135292);
        return c43747a;
    }

    public static C22488e cMf() {
        AppMethodBeat.m2504i(135293);
        C1720g.m3534RN().mo5159QU();
        if (C43749c.cMd().tcH == null) {
            C43749c.cMd().tcH = new C22488e();
        }
        C22488e c22488e = C43749c.cMd().tcH;
        AppMethodBeat.m2505o(135293);
        return c22488e;
    }

    public static C43750d cMg() {
        AppMethodBeat.m2504i(135294);
        C43750d c43750d = C43749c.cMd().tcI;
        AppMethodBeat.m2505o(135294);
        return c43750d;
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
        AppMethodBeat.m2504i(135295);
        C4990ab.m7410d("MicroMsg.SubCoreVoipCS", "now account reset!");
        C4879a.xxA.mo10052c(this.tcJ);
        C4879a.xxA.mo10052c(this.tcK);
        AppMethodBeat.m2505o(135295);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(135296);
        C4879a.xxA.mo10053d(this.tcJ);
        C4879a.xxA.mo10053d(this.tcK);
        AppMethodBeat.m2505o(135296);
    }
}
