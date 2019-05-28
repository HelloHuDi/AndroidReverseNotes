package com.tencent.p177mm.plugin.wallet_index.p564c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.opensdk.modelpay.PayReq;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.C46527bio;
import com.tencent.p177mm.protocal.protobuf.bin;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.wallet_index.c.g */
public class C46377g extends C36378u implements C44426i {
    public C7472b ehh;
    private C1202f ehi;

    public C46377g(PayReq payReq, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(48187);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bin();
        c1196a.fsK = new C46527bio();
        c1196a.uri = getUri();
        c1196a.fsI = getType();
        c1196a.fsO = C36391e.atB(payReq.prepayId);
        this.ehh = c1196a.acD();
        bin bin = (bin) this.ehh.fsG.fsP;
        bin.fKh = payReq.appId;
        bin.wLU = payReq.partnerId;
        bin.wlb = payReq.prepayId;
        bin.vYO = payReq.nonceStr;
        bin.wLV = payReq.timeStamp;
        bin.vYP = payReq.packageValue;
        bin.vYQ = payReq.sign;
        bin.vYR = payReq.signType;
        bin.wLW = str;
        bin.mZu = str2;
        bin.ncH = str3;
        bin.vRP = C22594k.cPy();
        bin.wLY = str4;
        AppMethodBeat.m2505o(48187);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48188);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48188);
        return a;
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48189);
        C4990ab.m7410d("MicroMsg.NetScenePayAuthApp", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(48189);
    }

    public int getType() {
        return 397;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/payauthapp";
    }
}
