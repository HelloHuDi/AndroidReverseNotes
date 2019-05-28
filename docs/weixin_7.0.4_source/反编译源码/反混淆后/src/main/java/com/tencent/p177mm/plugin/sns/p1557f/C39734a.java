package com.tencent.p177mm.plugin.sns.p1557f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C42049rj;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C39731e;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C44222az;

/* renamed from: com.tencent.mm.plugin.sns.f.a */
public final class C39734a implements C43559b {
    public C4884c qGl = new C397351();

    /* renamed from: com.tencent.mm.plugin.sns.f.a$1 */
    class C397351 extends C4884c<C42049rj> {
        C397351() {
            AppMethodBeat.m2504i(35873);
            this.xxI = C42049rj.class.getName().hashCode();
            AppMethodBeat.m2505o(35873);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(35874);
            C42049rj c42049rj = (C42049rj) c4883b;
            if (c42049rj instanceof C42049rj) {
                if (c42049rj.cNq.cuy == 1) {
                    C4990ab.m7417i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "start do download id %s", c42049rj.cNq.cNr.f17915Id);
                    C39731e c39731e = new C39731e(c42049rj.cNq.cNr);
                    c39731e.qFQ = 1;
                    c39731e.nQB = c42049rj.cNq.cNr.f17915Id;
                    if (c42049rj.cNq.cNr.jCt == 6) {
                        C13373af.cnA().mo69138a(c42049rj.cNq.cNr, 5, c39731e, C44222az.xYW);
                    } else {
                        C13373af.cnA().mo69138a(c42049rj.cNq.cNr, 1, c39731e, C44222az.xYW);
                    }
                } else if (c42049rj.cNq.cuy == 3) {
                    String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), c42049rj.cNq.cHr);
                    String Xa = C29036i.m46078Xa(c42049rj.cNq.cHr);
                    c42049rj.cNq.path = fZ + Xa;
                }
            }
            AppMethodBeat.m2505o(35874);
            return false;
        }
    }

    public C39734a() {
        AppMethodBeat.m2504i(35875);
        C4879a.xxA.mo10052c(this.qGl);
        C13373af.cnA().mo69136a((C43559b) this);
        AppMethodBeat.m2505o(35875);
    }

    /* renamed from: Xw */
    public final void mo17655Xw(String str) {
        AppMethodBeat.m2504i(35876);
        C4990ab.m7417i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", str);
        C42049rj c42049rj = new C42049rj();
        c42049rj.cNq.cuy = 2;
        c42049rj.cNq.cHr = str;
        String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), str);
        c42049rj.cNq.path = fZ + C29036i.m46078Xa(str);
        C4879a.xxA.mo10055m(c42049rj);
        AppMethodBeat.m2505o(35876);
    }

    /* renamed from: bj */
    public final void mo8771bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    /* renamed from: bk */
    public final void mo8772bk(String str, boolean z) {
    }
}
