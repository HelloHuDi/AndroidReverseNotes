package com.tencent.p177mm.plugin.luckymoney.appbrand.p988a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.bhj;
import com.tencent.p177mm.protocal.protobuf.bhk;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.a.b */
public final class C39305b extends C46056a<bhj, bhk> {
    public C39305b(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(41983);
        bhj bhj = new bhj();
        bhj.csB = str;
        bhj.wKw = str2;
        bhj.wKx = C1332b.m2847bI(bArr);
        this.nRK = bhj;
        AppMethodBeat.m2505o(41983);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKS() {
        AppMethodBeat.m2504i(41984);
        C4990ab.m7416i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiStart ");
        AppMethodBeat.m2505o(41984);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKT() {
        AppMethodBeat.m2504i(41985);
        C4990ab.m7416i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiEnd ");
        AppMethodBeat.m2505o(41985);
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/openwxaapphb";
    }

    /* renamed from: ZU */
    public final int mo24259ZU() {
        return 2701;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ btd bKR() {
        AppMethodBeat.m2504i(41986);
        bhk bhk = new bhk();
        AppMethodBeat.m2505o(41986);
        return bhk;
    }
}
