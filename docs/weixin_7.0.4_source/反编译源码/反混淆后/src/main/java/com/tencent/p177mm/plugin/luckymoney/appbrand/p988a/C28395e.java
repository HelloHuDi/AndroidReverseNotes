package com.tencent.p177mm.plugin.luckymoney.appbrand.p988a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.bsu;
import com.tencent.p177mm.protocal.protobuf.bsv;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.a.e */
public final class C28395e extends C46056a<bsu, bsv> {
    public C28395e(bsu bsu) {
        this.nRK = bsu;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKS() {
        AppMethodBeat.m2504i(41991);
        C4990ab.m7416i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiStart ");
        AppMethodBeat.m2505o(41991);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKT() {
        AppMethodBeat.m2504i(41992);
        C4990ab.m7416i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiEnd ");
        AppMethodBeat.m2505o(41992);
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/requestwxaapphb";
    }

    /* renamed from: ZU */
    public final int mo24259ZU() {
        return 2857;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ btd bKR() {
        AppMethodBeat.m2504i(41993);
        bsv bsv = new bsv();
        AppMethodBeat.m2505o(41993);
        return bsv;
    }
}
