package com.tencent.p177mm.plugin.wallet.pay.p554a.p1047b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40549ne;
import com.tencent.p177mm.protocal.protobuf.C46568nd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.b.a */
public class C29594a extends C36378u {
    private C7472b ehh;
    private C1202f ehi;

    public C29594a(String str, int i, int i2) {
        AppMethodBeat.m2504i(45933);
        C1196a c1196a = new C1196a();
        C46568nd c46568nd = new C46568nd();
        c46568nd.vHD = str;
        c46568nd.vRK = i;
        c46568nd.vRL = i2;
        c1196a.fsJ = c46568nd;
        c1196a.fsK = new C40549ne();
        c1196a.uri = getUri();
        c1196a.fsI = mo26464ZU();
        c1196a.fsO = C36391e.atB(str);
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneCancelPay", "request uri: %s, reqKey: %s, payScene: %d, payChannel:%d", getUri(), str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(45933);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(45934);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(45934);
        return a;
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(45935);
        C4990ab.m7411d("MicroMsg.NetSceneCancelPay", "response uri: %s, errType: %d, errCode: %d, errMsg: %s", getUri(), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            try {
                C40549ne c40549ne = (C40549ne) ((C7472b) c1929q).fsH.fsP;
                C4990ab.m7417i("MicroMsg.NetSceneCancelPay", "NetSceneCancelPay BaseResponse.Ret is %d, BaseResponse.ErrMsg is %s", Integer.valueOf(c40549ne.BaseResponse.Ret), c40549ne.BaseResponse.ErrMsg);
            } catch (Exception e) {
                C4990ab.m7416i("MicroMsg.NetSceneCancelPay", e.getMessage());
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(45935);
    }

    public final int getType() {
        AppMethodBeat.m2504i(138992);
        int ZU = mo26464ZU();
        AppMethodBeat.m2505o(138992);
        return ZU;
    }

    /* renamed from: ZU */
    public int mo26464ZU() {
        return 2823;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_cancelpay";
    }
}
