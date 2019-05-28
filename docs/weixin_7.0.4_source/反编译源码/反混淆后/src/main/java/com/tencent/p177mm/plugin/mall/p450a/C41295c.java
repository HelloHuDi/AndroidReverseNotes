package com.tencent.p177mm.plugin.mall.p450a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.protocal.protobuf.C15319aw;
import com.tencent.p177mm.protocal.protobuf.bok;
import com.tencent.p177mm.protocal.protobuf.bol;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.mall.a.c */
public final class C41295c extends C37440a<bol> {
    public C41295c(long j) {
        AppMethodBeat.m2504i(43094);
        bok bok = new bok();
        bok.wRk = (int) j;
        bok.wRl = C1332b.akB("all_type");
        C15319aw cPy = C22594k.cPy();
        if (cPy != null) {
            if (!C5046bo.isNullOrNil(cPy.duc)) {
                bok.wRm = C1332b.akB(cPy.duc);
            }
            if (!C5046bo.isNullOrNil(cPy.dud)) {
                bok.wRn = C1332b.akB(cPy.dud);
            }
        }
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        bok.vZt = 0;
        if (c30052l != null) {
            bok.vZu = 1;
        } else {
            bok.vZu = 0;
        }
        bok.wRo = 1;
        bok.timestamp = System.currentTimeMillis();
        C1196a c1196a = new C1196a();
        c1196a.fsJ = bok;
        c1196a.fsK = new bol();
        c1196a.fsI = 2672;
        c1196a.uri = "/cgi-bin/mmpay-bin/tenpay/querywechatwallet";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.CgiQueryWeChatWallet", "balanceVersion: %s, isRoot: %s, openTouch: %s", Long.valueOf(j), Integer.valueOf(bok.vZt), Integer.valueOf(bok.vZu));
        AppMethodBeat.m2505o(43094);
    }
}
