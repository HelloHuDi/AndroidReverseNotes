package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.g.a.km;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;

public final class l implements s<cm> {
    public final /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(18267);
        final String a = aa.a(((cm) aVar).vEB);
        if (t.kH(a)) {
            aw.ZK();
            final u ob = c.XV().ob(a);
            aw.ZK();
            ad aoO = c.XM().aoO(a);
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                ao.a.flu.a(a, null, new b.a() {
                    public final void o(String str, boolean z) {
                        AppMethodBeat.i(18266);
                        if (ob != null && ob.drU()) {
                            km kmVar = new km();
                            kmVar.cGi.chatroomName = a;
                            kmVar.cGi.cGj = ob.drT();
                            com.tencent.mm.sdk.b.a.xxA.m(kmVar);
                        }
                        AppMethodBeat.o(18266);
                    }
                });
                AppMethodBeat.o(18267);
                return;
            } else if (ob.drU()) {
                km kmVar = new km();
                kmVar.cGi.chatroomName = a;
                kmVar.cGi.cGj = ob.drT();
                com.tencent.mm.sdk.b.a.xxA.m(kmVar);
            }
        }
        AppMethodBeat.o(18267);
    }

    public final /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(18268);
        String a = aa.a(((cm) aVar).vEB);
        if (!(bo.isNullOrNil(a) || ((j) g.K(j.class)).XM().aoQ(a))) {
            ao.a.flu.ai(a, "");
        }
        AppMethodBeat.o(18268);
    }
}
