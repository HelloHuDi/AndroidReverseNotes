package com.tencent.mm.plugin.aa.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.b;

public final class a extends com.tencent.mm.vending.app.a {
    int gmt = 0;
    String gmu;
    int gmv;
    int gmw;
    String gmx;
    boolean gmy = false;
    int gmz;

    /* renamed from: com.tencent.mm.plugin.aa.a.c.a$1 */
    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<x>> {
        final /* synthetic */ b gmA;

        AnonymousClass1(b bVar) {
            this.gmA = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40675);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                x xVar = (x) aVar.fsy;
                ab.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, retcode: %s, retmsg: %s", Integer.valueOf(xVar.kCl), xVar.kCm);
                if (xVar.kCl == 0) {
                    ab.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish get success, return record size: %s", Integer.valueOf(xVar.vAD.size()));
                    a.this.gmt += xVar.vAD.size();
                    a.this.gmu = xVar.vAz;
                    a.this.gmv = xVar.vAA;
                    a.this.gmw = xVar.vAB;
                    a.this.gmx = xVar.vAC;
                    if (bo.isNullOrNil(a.this.gmu) || bo.isNullOrNil(a.this.gmx)) {
                        a.this.gmy = false;
                    } else {
                        a.this.gmy = true;
                    }
                    ab.d("MicroMsg.AAQueryListInteractor", "bill_id: %s, trans_id %s", a.this.gmu, a.this.gmx);
                    this.gmA.B(xVar.vAD, xVar.vAE, Boolean.valueOf(a.this.gmy));
                    h.pYm.a(407, 30, 1, false);
                } else if (xVar.kCl <= 0 || !bo.isNullOrNil(xVar.kCm)) {
                    this.gmA.cR(Boolean.FALSE);
                    h.pYm.a(407, 32, 1, false);
                } else {
                    this.gmA.cR(xVar.kCm);
                    h.pYm.a(407, 32, 1, false);
                }
            } else {
                this.gmA.cR(Boolean.FALSE);
                h.pYm.a(407, 31, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.o(40675);
            return voidR;
        }
    }

    public final void onCreate() {
        AppMethodBeat.i(40676);
        super.onCreate();
        AppMethodBeat.o(40676);
    }
}
