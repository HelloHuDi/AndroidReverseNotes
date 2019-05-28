package com.tencent.p177mm.plugin.p268aa.p269a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p268aa.C45488b;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C45482j;
import com.tencent.p177mm.plugin.p268aa.p269a.p879b.C26535c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C15389v;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;

/* renamed from: com.tencent.mm.plugin.aa.a.b */
public final class C32892b implements C1202f {
    C5688b glt;

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(40594);
        C4990ab.m7417i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            C15389v c15389v = ((C45482j) c1207m).gmq;
            C4990ab.m7417i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", Integer.valueOf(c15389v.kCl));
            if (c15389v.kCl == 0) {
                C5698f.m8556a(this.glt, c15389v);
                C7060h.pYm.mo8378a(407, 6, 1, false);
                C26535c vH = C45488b.aod().mo21152vH(c15389v.vzL);
                if (vH != null) {
                    vH.field_status = c15389v.state;
                    C45488b.aod().mo21151b(vH);
                }
                AppMethodBeat.m2505o(40594);
                return;
            }
            if (c15389v.kCl <= 0 || C5046bo.isNullOrNil(c15389v.kCm)) {
                this.glt.mo11582cR(Boolean.FALSE);
            } else {
                this.glt.mo11582cR(c15389v.kCm);
            }
            C7060h.pYm.mo8378a(407, 8, 1, false);
            AppMethodBeat.m2505o(40594);
            return;
        }
        if (this.glt != null) {
            this.glt.mo11582cR(Boolean.FALSE);
        }
        C7060h.pYm.mo8378a(407, 7, 1, false);
        AppMethodBeat.m2505o(40594);
    }
}
