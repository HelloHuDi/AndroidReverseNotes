package com.tencent.p177mm.plugin.p268aa.p269a.p717c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C7559x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.app.C16025a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;

/* renamed from: com.tencent.mm.plugin.aa.a.c.a */
public final class C26536a extends C16025a {
    int gmt = 0;
    String gmu;
    int gmv;
    int gmw;
    String gmx;
    boolean gmy = false;
    int gmz;

    /* renamed from: com.tencent.mm.plugin.aa.a.c.a$1 */
    class C67021 implements C5681a<Void, C37441a<C7559x>> {
        final /* synthetic */ C5688b gmA;

        C67021(C5688b c5688b) {
            this.gmA = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40675);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C7559x c7559x = (C7559x) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, retcode: %s, retmsg: %s", Integer.valueOf(c7559x.kCl), c7559x.kCm);
                if (c7559x.kCl == 0) {
                    C4990ab.m7417i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish get success, return record size: %s", Integer.valueOf(c7559x.vAD.size()));
                    C26536a.this.gmt += c7559x.vAD.size();
                    C26536a.this.gmu = c7559x.vAz;
                    C26536a.this.gmv = c7559x.vAA;
                    C26536a.this.gmw = c7559x.vAB;
                    C26536a.this.gmx = c7559x.vAC;
                    if (C5046bo.isNullOrNil(C26536a.this.gmu) || C5046bo.isNullOrNil(C26536a.this.gmx)) {
                        C26536a.this.gmy = false;
                    } else {
                        C26536a.this.gmy = true;
                    }
                    C4990ab.m7411d("MicroMsg.AAQueryListInteractor", "bill_id: %s, trans_id %s", C26536a.this.gmu, C26536a.this.gmx);
                    this.gmA.mo11581B(c7559x.vAD, c7559x.vAE, Boolean.valueOf(C26536a.this.gmy));
                    C7060h.pYm.mo8378a(407, 30, 1, false);
                } else if (c7559x.kCl <= 0 || !C5046bo.isNullOrNil(c7559x.kCm)) {
                    this.gmA.mo11582cR(Boolean.FALSE);
                    C7060h.pYm.mo8378a(407, 32, 1, false);
                } else {
                    this.gmA.mo11582cR(c7559x.kCm);
                    C7060h.pYm.mo8378a(407, 32, 1, false);
                }
            } else {
                this.gmA.mo11582cR(Boolean.FALSE);
                C7060h.pYm.mo8378a(407, 31, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(40675);
            return voidR;
        }
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(40676);
        super.onCreate();
        AppMethodBeat.m2505o(40676);
    }
}
