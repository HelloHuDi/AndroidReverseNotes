package com.tencent.p177mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C45356pd;
import com.tencent.p177mm.p230g.p231a.C9377ia;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C39761q;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbg;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.sns.d */
public final class C34934d extends C4884c<C9377ia> implements C1202f {
    private int qBW;
    private cbf qBX;
    private C46236n qBY;
    private C7564ap qBZ;

    /* renamed from: com.tencent.mm.plugin.sns.d$1 */
    class C290351 implements C5015a {
        C290351() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(35603);
            C45356pd c45356pd = new C45356pd();
            c45356pd.cLs.cCZ = null;
            C4879a.xxA.mo10055m(c45356pd);
            AppMethodBeat.m2505o(35603);
            return false;
        }
    }

    public C34934d() {
        AppMethodBeat.m2504i(35604);
        this.xxI = C9377ia.class.getName().hashCode();
        AppMethodBeat.m2505o(35604);
    }

    /* renamed from: a */
    private boolean m57350a(C9377ia c9377ia) {
        AppMethodBeat.m2504i(35605);
        if (c9377ia instanceof C9377ia) {
            this.qBW = c9377ia.cCX.cyN;
            this.qBY = C13373af.cnF().mo62914DK(this.qBW);
            this.qBX = C34955aj.m57408p(this.qBY);
            if (this.qBX == null || ((this.qBX.wGz != 3 || this.qBX.xaB == null || this.qBX.xaB.size() <= 0) && (this.qBX.wGz != 5 || this.qBX.wFp == null || this.qBX.wFp.size() <= 0))) {
                C1207m c39761q = new C39761q(this.qBY.field_snsId);
                ((cbg) c39761q.ehh.fsG.fsP).xaH = 1;
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14539a(210, (C1202f) this);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c39761q, 0);
                this.qBZ = new C7564ap(new C290351(), false);
                this.qBZ.mo16770ae(10000, 10000);
                AppMethodBeat.m2505o(35605);
                return true;
            }
            c9377ia.cCY.cCZ = this.qBX;
            AppMethodBeat.m2505o(35605);
            return true;
        }
        C4990ab.m7414f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        AppMethodBeat.m2505o(35605);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(35606);
        C4990ab.m7417i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.qBZ.stopTimer();
        if (i == 0 && i2 == 0) {
            C46236n kD = C13373af.cnF().mo62941kD(this.qBY.field_snsId);
            C45356pd c45356pd = new C45356pd();
            c45356pd.cLs.cCZ = C34955aj.m57408p(kD);
            C4879a.xxA.mo10055m(c45356pd);
            AppMethodBeat.m2505o(35606);
            return;
        }
        C45356pd c45356pd2 = new C45356pd();
        c45356pd2.cLs.cCZ = null;
        C4879a.xxA.mo10055m(c45356pd2);
        AppMethodBeat.m2505o(35606);
    }
}
