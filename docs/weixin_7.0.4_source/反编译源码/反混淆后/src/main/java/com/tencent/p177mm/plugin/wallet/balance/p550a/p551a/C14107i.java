package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35921ha;
import com.tencent.p177mm.protocal.protobuf.blg;
import com.tencent.p177mm.protocal.protobuf.blh;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.i */
public final class C14107i extends C37440a<blh> {
    public C14107i(int i, C35921ha c35921ha, int i2, int i3, String str) {
        AppMethodBeat.m2504i(45235);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new blg();
        c1196a.fsK = new blh();
        c1196a.uri = "/cgi-bin/mmpay-bin/preredeemfund";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        blg blg = (blg) acD.fsG.fsP;
        blg.wOi = i;
        if (c35921ha != null) {
            blg.wOj = 1;
            blg.wOk = c35921ha;
        } else {
            blg.wOj = 0;
            blg.wOk = null;
        }
        blg.wao = i2;
        blg.wOl = i3;
        blg.wOm = str;
        blg.tgu = C14103ab.cMM();
        this.ehh = acD;
        AppMethodBeat.m2505o(45235);
    }
}
