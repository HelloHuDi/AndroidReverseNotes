package com.tencent.p177mm.plugin.wallet.balance.p550a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aev;
import com.tencent.p177mm.protocal.protobuf.aew;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a */
public final class C14115a extends C37440a<aew> {
    public C14115a() {
        AppMethodBeat.m2504i(45219);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aev();
        c1196a.fsK = new aew();
        c1196a.uri = "/cgi-bin/mmpay-bin/tenpay/getbalancemenu";
        this.ehh = c1196a.acD();
        C4990ab.m7416i("MicroMsg.CgiGetBalanceMenu", "get balance menu");
        AppMethodBeat.m2505o(45219);
    }
}
