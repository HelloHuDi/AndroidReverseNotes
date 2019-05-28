package com.tencent.mm.plugin.aa.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.a.c;
import com.tencent.mm.plugin.aa.a.g;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.q;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;

public class f extends a {
    c gmN = new c();
    g gmO = new g();
    j gmP = new j();

    /* renamed from: com.tencent.mm.plugin.aa.a.c.f$1 */
    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<q>> {
        final /* synthetic */ b gmA;

        AnonymousClass1(b bVar) {
            this.gmA = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40692);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.PaylistAAInteractor", "errType: %s, errCode: %s, retCode: %s, retMsg: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), Integer.valueOf(((q) aVar.fsy).kCl), ((q) aVar.fsy).kCm);
            this.gmA.resume();
            Void voidR = zXH;
            AppMethodBeat.o(40692);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.c.f$2 */
    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<s>> {
        final /* synthetic */ b gmA;

        AnonymousClass2(b bVar) {
            this.gmA = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40693);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                s sVar = (s) aVar.fsy;
                ab.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, retcode: %s, retmsg: %s", Integer.valueOf(sVar.kCl), sVar.kCm);
                if (sVar.kCl == 0) {
                    ab.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay success");
                    com.tencent.mm.plugin.aa.a.gkF.BS();
                    this.gmA.B(Boolean.TRUE);
                    h.pYm.a(407, 24, 1, false);
                } else {
                    if (sVar.kCl <= 0 || bo.isNullOrNil(sVar.kCm)) {
                        this.gmA.cR(Boolean.FALSE);
                    } else {
                        this.gmA.cR(sVar.kCm);
                    }
                    h.pYm.a(407, 26, 1, false);
                }
            } else {
                this.gmA.cR(Boolean.FALSE);
                h.pYm.a(407, 25, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.o(40693);
            return voidR;
        }
    }

    public f() {
        AppMethodBeat.i(40694);
        AppMethodBeat.o(40694);
    }

    public final void onCreate() {
        AppMethodBeat.i(40695);
        super.onCreate();
        com.tencent.mm.ai.f aof = this.gmN.aof();
        ab.i("MicroMsg.AAGetPaylistDetailLogic", "init");
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(1695, aof);
        aof = this.gmO.aol();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(1629, aof);
        this.gmP.aoo().init();
        AppMethodBeat.o(40695);
    }

    public final void onDestroy() {
        AppMethodBeat.i(40696);
        super.onDestroy();
        com.tencent.mm.ai.f aof = this.gmN.aof();
        ab.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(1695, aof);
        aof = this.gmO.aol();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(1629, aof);
        this.gmP.aoo().aon();
        AppMethodBeat.o(40696);
    }

    public final String mJ(String str) {
        AppMethodBeat.i(40697);
        String displayName = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(str, this.zXe.getStringExtra("chatroom"));
        AppMethodBeat.o(40697);
        return displayName;
    }
}
