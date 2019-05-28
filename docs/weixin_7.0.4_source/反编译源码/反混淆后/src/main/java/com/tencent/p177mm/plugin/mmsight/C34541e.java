package com.tencent.p177mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26232ri;
import com.tencent.p177mm.p230g.p231a.C42055rs;
import com.tencent.p177mm.plugin.mmsight.model.C3483l;
import com.tencent.p177mm.plugin.mmsight.model.C3486m;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.mmsight.e */
public class C34541e implements C1816at {
    private C3486m osT = new C3486m();
    private C4884c osU = new C125381();
    private C4884c osV = new C284972();

    /* renamed from: com.tencent.mm.plugin.mmsight.e$1 */
    class C125381 extends C4884c<C26232ri> {
        C125381() {
            AppMethodBeat.m2504i(76427);
            this.xxI = C26232ri.class.getName().hashCode();
            AppMethodBeat.m2505o(76427);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(76428);
            C26232ri c26232ri = (C26232ri) c4883b;
            c26232ri.cNo.result = C3475d.m5784tv(c26232ri.cNn.cNp);
            AppMethodBeat.m2505o(76428);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.e$2 */
    class C284972 extends C4884c<C42055rs> {
        C284972() {
            AppMethodBeat.m2504i(76429);
            this.xxI = C42055rs.class.getName().hashCode();
            AppMethodBeat.m2505o(76429);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(76430);
            C42055rs c42055rs = (C42055rs) c4883b;
            if (C3483l.m5789a(c42055rs.cNH.cNp, C42204d.afF().afH(), c42055rs.cNH.cNJ, c42055rs.cNH.cNL)) {
                c42055rs.cNH.cNK.run();
                c42055rs.cNI.result = C3483l.m5790b(c42055rs.cNH.cNp, C42204d.afF().afH(), c42055rs.cNH.cNJ, c42055rs.cNH.cNL);
            } else {
                c42055rs.cNI.result = 1;
            }
            AppMethodBeat.m2505o(76430);
            return false;
        }
    }

    public C34541e() {
        AppMethodBeat.m2504i(76431);
        AppMethodBeat.m2505o(76431);
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
        AppMethodBeat.m2504i(76432);
        C37961o.alq().mo44277a(this.osT);
        C4879a.xxA.mo10051b(this.osV);
        C4879a.xxA.mo10052c(this.osU);
        AppMethodBeat.m2505o(76432);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(76433);
        C37961o.alq().mo44281b(this.osT);
        C4879a.xxA.mo10053d(this.osV);
        C43305j.owk.mo45830WY();
        C4879a.xxA.mo10053d(this.osU);
        AppMethodBeat.m2505o(76433);
    }
}
