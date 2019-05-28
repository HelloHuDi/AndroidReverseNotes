package com.tencent.p177mm.plugin.p268aa.p269a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C37992i;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C15369o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;

/* renamed from: com.tencent.mm.plugin.aa.a.f */
public final class C32896f implements C1202f {
    boolean glH = false;
    C5688b glt;

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(40605);
        C4990ab.m7417i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        this.glH = false;
        if (i == 0 && i2 == 0) {
            C15369o c15369o = ((C37992i) c1207m).gmo;
            C4990ab.m7417i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", Integer.valueOf(c15369o.kCl), c15369o.kCm);
            if (c15369o.kCl == 0) {
                C5698f.m8556a(this.glt, c15369o);
                C7060h.pYm.mo8378a(407, 9, 1, false);
                AppMethodBeat.m2505o(40605);
                return;
            }
            if (this.glt != null) {
                if (c15369o.vAf != null && c15369o.vAf.bJt == 1 && !C5046bo.isNullOrNil(c15369o.vAf.kCs) && !C5046bo.isNullOrNil(c15369o.vAf.nZb) && !C5046bo.isNullOrNil(c15369o.vAf.nZc) && !C5046bo.isNullOrNil(c15369o.vAf.cEh)) {
                    this.glt.mo11582cR(c15369o.vAf);
                } else if (c15369o.kCl <= 0 || C5046bo.isNullOrNil(c15369o.kCm)) {
                    this.glt.mo11582cR(Boolean.FALSE);
                } else {
                    this.glt.mo11582cR(c15369o.kCm);
                }
            }
            C7060h.pYm.mo8378a(407, 11, 1, false);
            AppMethodBeat.m2505o(40605);
            return;
        }
        if (this.glt != null) {
            this.glt.mo11582cR(Boolean.FALSE);
        }
        C7060h.pYm.mo8378a(407, 10, 1, false);
        AppMethodBeat.m2505o(40605);
    }
}
