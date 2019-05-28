package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.bt.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends a<bol> {
    public c(long j) {
        AppMethodBeat.i(43094);
        bok bok = new bok();
        bok.wRk = (int) j;
        bok.wRl = b.akB("all_type");
        aw cPy = k.cPy();
        if (cPy != null) {
            if (!bo.isNullOrNil(cPy.duc)) {
                bok.wRm = b.akB(cPy.duc);
            }
            if (!bo.isNullOrNil(cPy.dud)) {
                bok.wRn = b.akB(cPy.dud);
            }
        }
        l lVar = (l) g.K(l.class);
        bok.vZt = 0;
        if (lVar != null) {
            bok.vZu = 1;
        } else {
            bok.vZu = 0;
        }
        bok.wRo = 1;
        bok.timestamp = System.currentTimeMillis();
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = bok;
        aVar.fsK = new bol();
        aVar.fsI = 2672;
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/querywechatwallet";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiQueryWeChatWallet", "balanceVersion: %s, isRoot: %s, openTouch: %s", Long.valueOf(j), Integer.valueOf(bok.vZt), Integer.valueOf(bok.vZu));
        AppMethodBeat.o(43094);
    }
}
