package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aev;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends com.tencent.mm.ai.a<aew> {
    public a() {
        AppMethodBeat.i(45219);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new aev();
        aVar.fsK = new aew();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getbalancemenu";
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiGetBalanceMenu", "get balance menu");
        AppMethodBeat.o(45219);
    }
}
